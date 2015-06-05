import java.awt.Color;
import java.awt.image.BufferedImage;


public class Erosion {

	public Erosion(){

	}

	public BufferedImage erosion(BufferedImage image1){

		BufferedImage image2 = new BufferedImage(image1.getWidth(),image1.getHeight(),BufferedImage.TYPE_INT_RGB);
		int [][] pixel= new int[image1.getWidth()][image1.getHeight()];
		// int[] rgb = new int[3];
		//int t=0;
		for (int i = 0; i < image1.getWidth(); i++) 
		{
			for (int j = 0; j < image1.getHeight(); j++) 
			{



				int RVB = image1.getRGB(i, j);


				pixel[i][j]=(RVB>>16)& 0xFF;
			}
		}
		for (int i = 2; i < image1.getWidth()-2; i++) 
		{
			for (int j = 2; j < image1.getHeight()-2; j++) {

				// recuperer couleur de chaque pixel
				//	                    int RVB = image1.getRGB(i, j);
				//								int r=(RVB>>16)& 0xFF;
				//								int g=(RVB>>8)& 0xFF;
				//								int b=(RVB)& 0xFF;
				//								System.out.println(RVB);

				if ((pixel[i-1][j-1]==255)|
						(pixel[i][j-1]==255)|
						(pixel[i+1][j-1]==255)|
						(pixel[i-1][j]==255)|
						(pixel[i+1][j]==255)|
						(pixel[i-1][j+1]==255)|
						(pixel[i][j+1]==255)|
						(pixel[i+1][j+1]==255)
						) {
					//				if (
					//						
					//						(pixel[i][j-1]==-16777216)&&
					//						
					//						(pixel[i-1][j]==-16777216)&&
					//						(pixel[i+1][j]==-16777216)
					//						&&(pixel[i][j+1]==-16777216)) {				
					int rgb=new Color(255,255,255).getRGB();
					image2.setRGB(i, j, rgb);

				} else {
					int rgb=new Color(0,0,0).getRGB();
					image2.setRGB(i, j, rgb);

				}


			}
		}
		return image2;

	}
	public BufferedImage erosionTrois(BufferedImage image1){

		BufferedImage image2 = new BufferedImage(image1.getWidth(),image1.getHeight(),BufferedImage.TYPE_INT_RGB);
		int [][] pixel= new int[image1.getWidth()][image1.getHeight()];
		// int[] rgb = new int[3];
		//int t=0;
		for (int i = 0; i < image1.getWidth(); i++) 
		{
			for (int j = 0; j < image1.getHeight(); j++) 
			{



				int RVB = image1.getRGB(i, j);


				pixel[i][j]=(RVB>>16)& 0xFF;
			}
		}
		for (int i = 2; i < image1.getWidth()-2; i++) 
		{
			for (int j = 2; j < image1.getHeight()-2; j++) {

				// recuperer couleur de chaque pixel
				//	                    int RVB = image1.getRGB(i, j);
				//								int r=(RVB>>16)& 0xFF;
				//								int g=(RVB>>8)& 0xFF;
				//								int b=(RVB)& 0xFF;
				//								System.out.println(RVB);

				if ((pixel[i-1][j-1]==255)|
						(pixel[i][j-1]==255)|
//						(pixel[i+1][j-1]==255)|
						(pixel[i-1][j]==255)|
//						(pixel[i+1][j]==255)|
						(pixel[i-1][j+1]==255)
//						(pixel[i][j+1]==255)|
//						(pixel[i+1][j+1]==255)
						) {
					//				if (
					//						
					//						(pixel[i][j-1]==-16777216)&&
					//						
					//						(pixel[i-1][j]==-16777216)&&
					//						(pixel[i+1][j]==-16777216)
					//						&&(pixel[i][j+1]==-16777216)) {				
					int rgb=new Color(255,255,255).getRGB();
					image2.setRGB(i, j, rgb);

				} else {
					int rgb=new Color(0,0,0).getRGB();
					image2.setRGB(i, j, rgb);

				}


			}
		}
		return image2;

	}



}
