import java.awt.Color;
import java.awt.image.BufferedImage;


public class EyeMapL {

	
	public EyeMapL(){
		
	}
	
	
	
public BufferedImage CalculeMapL(BufferedImage Dilatation , BufferedImage Erosion,int w,int h){
		
		BufferedImage image2 = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		int [][] dilatation = new int [w][h];
		int [][] erosion = new int [w][h];
		for (int i = 0; i < Dilatation.getWidth(); i++) 
		{
			for (int j = 0; j < Dilatation.getHeight(); j++) 
			{
				int RVB = Dilatation.getRGB(i, j);
				 int r=(RVB>>16)& 0xFF;
				 dilatation[i][j]=r;
				 
			}
		}
		
		for (int i = 0; i < Erosion.getWidth(); i++) 
		{
			for (int j = 0; j < Erosion.getHeight(); j++) 
			{
				int RVB = Erosion.getRGB(i, j);
				 int r=(RVB>>16)& 0xFF;
				 erosion[i][j]=r;
			}
		}
		double valeur;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				
					
				erosion[i][j]=erosion[i][j]+1;
			
				
				valeur= (double) dilatation[i][j]/ (double) erosion[i][j];
				valeur= valeur*255;
				//System.out.println(valeur);
				  valeur= Math.min(valeur, 255);
				int rgb=new Color((int)valeur,(int)valeur,(int)valeur).getRGB();
				image2.setRGB(i, j, rgb);
				
			}
			
		}
		
		return image2;
	}
}
