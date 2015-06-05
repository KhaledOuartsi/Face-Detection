import java.awt.Color;
import java.awt.image.BufferedImage;

/**
*
* @author Khaled
*/

public class EyeConfirme {

	public EyeConfirme(){

	}

	int jmax = 20;

	public BufferedImage EyeConfirmeC(BufferedImage image, int i0,int i1, int i2, int i3){
		//	public BufferedImage EyeConfirmeFace(BufferedImage image){

		BufferedImage image2 = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
		int max = 0;
		//		int distanceAB = (int) (Math.pow((i3*2-i1*2), 2)+ Math.pow((i2*2-i2*2), 2));
		//    	int distanceAC = (int) (Math.pow((i3*2-i3*2), 2)+ Math.pow((i2*2-i4*2), 2));
		int pix[][]= new int [image.getWidth()][image.getHeight()];

		for (int x = i0; x < i2; x++) 
		{
			for (int y = i1; y < i3; y++) {

				int RVB = image.getRGB(x, y);
				int r=(RVB>>16)& 0xFF;
				int g=(RVB>>8)& 0xFF;
				int b=(RVB)& 0xFF;
				//				int y  = (int)( (0.299   * r) + (0.587   * g) + (0.114   * b));
				//		        int cb = b-y;//(int)(-0.16874 * r - 0.33126 * g + 0.50000 * b);
				//		        
				//				int cr = r-y;//(int)( 0.50000 * r - 0.41869 * g - 0.08131 * b);


				int Cb=(int) (((-0.168736* r)+(-0.331264* g)+(0.5* b))+128);

				int  Cr=(int) (((0.5* r)+(-0.418688* g)+(-0.081312* b))+128);
				//------------------------------------------------------------
				int Cbcare = (int) Math.pow(Cb, 2);

				int CrNegativeCare = (int) Math.pow((255-Cr), 2);

				int CbCr= Cb/Cr;


				int eyeMap =  (Cbcare+CrNegativeCare+CbCr)/3;
				max=Math.max(max, eyeMap);
				pix[x][y]=eyeMap;

			}
		}
		for (int i = i0; i < i2; i++) 
		{
			for (int j = i1; j < i3; j++) {
				int eyeMap=(int)(pix[i][j]*255/max);
				int rgb=new Color(eyeMap,eyeMap,eyeMap).getRGB(); 
				image2.setRGB(i, j, rgb);
			}
		}

		return image2;
	}



	public BufferedImage EyeSeuille(BufferedImage image , int i0,int i1,int i2,int i3){

		BufferedImage image2 = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
		BufferedImage grayscale = toGray(image, i0, i1, i2, i3);
		int threshold = otsuTreshold(grayscale, i0, i1, i2, i3);
		//System.out.println(threshold);
		for (int i = i0; i < i2; i++) 
		{
			for (int j = i1; j < i3; j++) {
				int RVB = image.getRGB(i, j);
				int r=(RVB>>16)& 0xFF;
				int g=(RVB>>8)& 0xFF;
				int b=(RVB)& 0xFF;
				int gris = (int) (0.21 * r + 0.71 * g + 0.07 * b);
				
				if (gris>=threshold) {

					int rgb=new Color(255,255,255).getRGB(); 
					image2.setRGB(i, j, rgb);
				}
				// System.out.println(r+" "+g+" "+b);

			}
		}

		return image2;

	}

	public BufferedImage CalculeMapL(BufferedImage Dilatation , BufferedImage Erosion,int w,int h,int i0,int i1,int i2,int i3){

		BufferedImage image2 = new BufferedImage(w,h,8);
		int [][] dilatation = new int [w][h];
		int [][] erosion = new int [w][h];
		int [][] normalisation = new int [w][h];
		int max =0;

		for (int i = i0; i < i2; i++) 
		{
			for (int j = i1; j < i3; j++) 
			{
				int RVB = Dilatation.getRGB(i, j);
				int r=(RVB>>16)& 0xFF;
				dilatation[i][j]=r;
			}
		}

		for (int i = i0; i < i2; i++) 
		{
			for (int j = i1; j < i3; j++)
			{
				int RVB = Erosion.getRGB(i, j);
				int r=(RVB>>16)& 0xFF;
				erosion[i][j]=r;
			}
		}
		double valeur;
		for (int i = i0; i < i2; i++) {
			for (int j = i1; j < i3; j++) {


				erosion[i][j]=erosion[i][j]+1;


				valeur= (double) dilatation[i][j]/ (double) erosion[i][j];
				valeur= valeur*255;
				//System.out.println(valeur);
				max= (int) Math.max(max, valeur);
				normalisation[i][j]= (int) valeur;



			}

		}

		for (int i = i0; i < i2; i++) {
			for (int j = i1; j < i3; j++) {

				int eyeMap=(int)(normalisation[i][j]*255/max);

				int rgb=new Color(eyeMap,eyeMap,eyeMap).getRGB(); 
				image2.setRGB(i, j, rgb);

			}
		}

		return image2;
	}

	public BufferedImage Candface(BufferedImage C ,BufferedImage Face,int w,int h){
		BufferedImage image2 = new BufferedImage(w,h,8);

		int [][] c = new int [w][h];
		int [][] face = new int [w][h];

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {

				int RVB = C.getRGB(i, j);
				int r=(RVB>>16)& 0xFF;

				c[i][j]=r;
				int RgB = Face.getRGB(i, j);
				int g=(RgB>>16)& 0xFF;
				face[i][j]=g;



			}

		}

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {

				int somme = c[i][j]*face[i][j];
				somme=Math.min(somme, 255);
				int rgb=new Color(somme,somme,somme).getRGB(); 
				image2.setRGB(i, j, rgb);

			}

		}
		return image2;

	}

	public static int[] imageHistogram(BufferedImage input,int i0,int i1,int i2,int i3) {

		int[] histogram = new int[256];

		for(int i=0; i<histogram.length; i++) histogram[i] = 0;

		for (int i = i0; i < i2; i++) {
			for (int j = i1; j < i3; j++) {
				int red = new Color(input.getRGB (i, j)).getRed();
				histogram[red]++;
			}
		}

		return histogram;

	}

	private static int otsuTreshold(BufferedImage original,int i0,int i1,int i2,int i3) {

		int[] histogram = imageHistogram(original, i0, i1, i2, i3);
		int total = (i2-i0) * (i3-i1);

		float sum = 0;
		for(int i=0; i<256; i++) sum += i * histogram[i];

		float sumB = 0;
		int wB = 0;
		int wF = 0;

		float varMax = 0;
		int threshold = 0;

		for(int i=0 ; i<256 ; i++) {
			wB += histogram[i];
			if(wB == 0) continue;
			wF = total - wB;

			if(wF == 0) break;

			sumB += (float) (i * histogram[i]);
			float mB = sumB / wB;
			float mF = (sum - sumB) / wF;

			float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);

			if(varBetween > varMax) {
				varMax = varBetween;
				threshold = i;
			}
		}

		return threshold;

	}
	 private static BufferedImage toGray(BufferedImage original,int i0,int i1,int i2,int i3) {
		 
	        int alpha, red, green, blue;
	        int newPixel;
	 
	        BufferedImage lum = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
	 
	        for (int i = i0; i < i2; i++) {
				for (int j = i1; j < i3; j++) {
	 
	                // Get pixels by R, G, B
	                alpha = new Color(original.getRGB(i, j)).getAlpha();
	                red = new Color(original.getRGB(i, j)).getRed();
	                green = new Color(original.getRGB(i, j)).getGreen();
	                blue = new Color(original.getRGB(i, j)).getBlue();
	 
	                red = (int) (0.21 * red + 0.71 * green + 0.07 * blue);
	                // Return back to original format
	                newPixel = colorToRGB(alpha, red, red, red);
	 
	                // Write pixels into image
	                lum.setRGB(i, j, newPixel);
	 
	            }
	        }
	 
	        return lum;
	 
	    }
	 private static int colorToRGB(int alpha, int red, int green, int blue) {
		 
	        int newPixel = 0;
	        newPixel += alpha;
	        newPixel = newPixel << 8;
	        newPixel += red; newPixel = newPixel << 8;
	        newPixel += green; newPixel = newPixel << 8;
	        newPixel += blue;
	 
	        return newPixel;
	 
	    }

}

