import java.awt.Color;
import java.awt.image.BufferedImage;


public class EyeMapC {

	
	public EyeMapC(){
		
	}

	public BufferedImage eyeMap(BufferedImage image1){
		
		BufferedImage image2 = new BufferedImage(image1.getWidth(),image1.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
		int max = 0;
		int C [][]= new int [image1.getWidth()][image1.getWidth()];
		 
		 int pix[][]= new int [image1.getWidth()][image1.getHeight()];
		 for (int i = 0; i < image1.getWidth(); i++) 
         {
                for (int j = 0; j < image1.getHeight(); j++) {
                 
                // recuperer couleur de chaque pixel
               // Color pixelcolor= new Color(image1.getRGB(i, j));
                 int RVB = image1.getRGB(i, j);
							int r=(RVB>>16)& 0xFF;
							int g=(RVB>>8)& 0xFF;
							int b=(RVB)& 0xFF;
							

							 int Cb=(int) (((-0.1687* r)+(-0.3313* g)+(0.5* b))+128);

							  int  Cr=(int) (((0.5* r)+(-0.4187* g)+(-0.0813* b))+128);
						  //------------------------------------------------------------
						  int Cbcare = (int) Math.pow(Cb, 2);
						
						  int CrNegativeCare = (int) Math.pow((255-Cr), 2);
						 
						  int CbCr= Cb/Cr;
						  
						int eyeMap =  (Cbcare+CrNegativeCare+CbCr)/3;
						max=Math.max(max, eyeMap);
						pix[i][j]=eyeMap;
	}
	
}
		 for (int i = 0; i < image1.getWidth(); i++) 
		 {
			 for (int j = 0; j < image1.getHeight(); j++) {
						int eyeMap=(int)(pix[i][j]*255/max);
						C[i][j]= eyeMap;
				 int rgb=new Color(eyeMap,eyeMap,eyeMap).getRGB(); 
				 image2.setRGB(i, j, rgb);
			 }
		 }
		 return image2;
		 
	}
}
	
 