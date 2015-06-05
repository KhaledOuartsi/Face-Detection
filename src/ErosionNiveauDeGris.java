import java.awt.Color;
import java.awt.image.BufferedImage;


public class ErosionNiveauDeGris {

	
	public ErosionNiveauDeGris(){
		
		
	}
	public int min ;
	public int Min (int []  valeur ){
		 min = valeur[0];
		
		for (int i = 0; i < valeur.length; i++) 
		{
			min = Math.min(min, valeur[i]);
		}
		
		
		return min;
	}
	
	public BufferedImage DilatationGris(BufferedImage image){
		BufferedImage image2 = new BufferedImage(image.getWidth(),image.getHeight(),8);
	int	pixel [][] = new int [image.getWidth()][image.getHeight()];
	int	Erosion [][] = new int [image.getWidth()][image.getHeight()];
	int valeur [] = new int [8];
	
	
		for (int i = 0; i < image.getWidth(); i++) 
		{
			for (int j = 0; j < image.getHeight(); j++) 
			{
				  int RVB = image.getRGB(i, j);
					int r=(RVB>>16)& 0xFF;
					int g=(RVB>>8)& 0xFF;
					int b=(RVB)& 0xFF;
					int Y =(int) ((0.299 * r)+(0.587* g)+(0.114* b));
				pixel[i][j]=Y;
			}
		}
		
		for (int i = 1; i < image.getWidth()-1; i++) 
		{
			for (int j = 1; j < image.getHeight()-1; j++) {
				valeur [0]= pixel [i-1][j-1];
				valeur [1]= pixel [i][j-1];
			//	valeur [2]= pixel [i+1][j-1];
				valeur [3]= pixel [i-1][j];
			//	valeur [4]= pixel [i+1][j];
				valeur [5]= pixel [i-1][j+1];
			//	valeur [6]= pixel [i][j+1];
				valeur [7]= pixel [i+1][j+1];
				
				min = Min(valeur);
				Erosion[i][j]=min;
			//	System.out.println(min);
				int rgb=new Color(min,min,min).getRGB();
				image2.setRGB(i, j, rgb);
				
			}
		}
		//System.out.println("Fin min");
		
		return image2;
		//return Erosion;
		
	}
	
	public BufferedImage DilatationGrisCare(BufferedImage image,int i0,int i1, int i2, int i3){
		BufferedImage image2 = new BufferedImage(image.getWidth(),image.getHeight(),8);
	int	pixel [][] = new int [image.getWidth()][image.getHeight()];
	int	Erosion [][] = new int [image.getWidth()][image.getHeight()];
	int valeur [] = new int [8];
	
	
		for (int i = i0; i < i2; i++) 
		{
			for (int j = i1; j < i3; j++) 
			{
				  int RVB = image.getRGB(i, j);
					int r=(RVB>>16)& 0xFF;
					int g=(RVB>>8)& 0xFF;
					int b=(RVB)& 0xFF;
					int Y =(int) ((0.299 * r)+(0.587* g)+(0.114* b));
				pixel[i][j]=Y;
			}
		}
		
		for (int i = i0+1; i < i2-1; i++) 
		{
			for (int j = i1+1; j < i3-1; j++) {
				valeur [0]= pixel [i-1][j-1];
				valeur [1]= pixel [i][j-1];
				valeur [2]= pixel [i+1][j-1];
				valeur [3]= pixel [i-1][j];
				valeur [4]= pixel [i+1][j];
				valeur [5]= pixel [i-1][j+1];
				valeur [6]= pixel [i][j+1];
				valeur [7]= pixel [i+1][j+1];
				
				int min = valeur[0];
					
					for (int x = 0; x < valeur.length; x++) 
					{
						min = Math.max(min, valeur[x]);
					}
				
				//min = Min(valeur);
				Erosion[i][j]=min;
			//	System.out.println(min);
				int rgb=new Color(min,min,min).getRGB();
				image2.setRGB(i, j, rgb);
				
			}
		}
		//System.out.println("Fin min");
		
		return image2;
		//return Erosion;
		
	}
}
