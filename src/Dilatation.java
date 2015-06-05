import java.awt.Color;
import java.awt.image.BufferedImage;


public class Dilatation {
	public Dilatation(){
		
	}
	public BufferedImage dilatation(BufferedImage image1){

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
				//System.out.println(pixel[i][j]);
			}
		}
		for (int i = 1; i < image1.getWidth()-1; i++) 
		{
			for (int j = 1; j < image1.getHeight()-1; j++) {

				// recuperer couleur de chaque pixel
//					                    
				
				//if ((pixel[i-1][j-1]==-16777216)|(pixel[i][j-1]==-16777216)|(pixel[i+1][j-1]==-16777216)|(pixel[i-1][j]==-16777216)|(pixel[i+1][j]==-16777216)|(pixel[i-1][j+1]==-16777216)|(pixel[i][j+1]==-16777216)|(pixel[i+1][j+1]==-16777216)) {
				if (
						(pixel[i-1][j-1]==0)|
								(pixel[i][j-1]==0)|
								(pixel[i+1][j-1]==0)|
								(pixel[i-1][j]==0)|
								(pixel[i+1][j]==0)|
								(pixel[i-1][j+1]==0)|
								(pixel[i][j+1]==0)|
								(pixel[i+1][j+1]==0)
								) {				
					int rgb=new Color(0,0,0).getRGB();
					image2.setRGB(i, j, rgb);

				} else {
					int rgb=new Color(255,255,255).getRGB();
					image2.setRGB(i, j, rgb);

				}


			}
		}
		return image2;

	}
	
	public BufferedImage dilatationTrois(BufferedImage image1){

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
				//System.out.println(pixel[i][j]);
			}
		}
		for (int i = 1; i < image1.getWidth()-1; i++) 
		{
			for (int j = 1; j < image1.getHeight()-1; j++) {

				// recuperer couleur de chaque pixel
//					                    
				
				//if ((pixel[i-1][j-1]==-16777216)|(pixel[i][j-1]==-16777216)|(pixel[i+1][j-1]==-16777216)|(pixel[i-1][j]==-16777216)|(pixel[i+1][j]==-16777216)|(pixel[i-1][j+1]==-16777216)|(pixel[i][j+1]==-16777216)|(pixel[i+1][j+1]==-16777216)) {
				if ((pixel[i-1][j-1]==255)|
						(pixel[i][j-1]==255)|
//						(pixel[i+1][j-1]==255)|
						(pixel[i-1][j]==255)|
//						(pixel[i+1][j]==255)|
						(pixel[i-1][j+1]==255)
//						(pixel[i][j+1]==255)|
//						(pixel[i+1][j+1]==255)
								) {				
					int rgb=new Color(0,0,0).getRGB();
					image2.setRGB(i, j, rgb);

				} else {
					int rgb=new Color(255,255,255).getRGB();
					image2.setRGB(i, j, rgb);

				}


			}
		}
		return image2;

	}

}
