import java.awt.Color;
import java.awt.image.BufferedImage;


public class DilatationNiveauDeGris {

	
	public DilatationNiveauDeGris(){
		
		
	}
	public int max ;
	public int Max (int []  valeur ){
		
		
		for (int i = 0; i < valeur.length; i++) 
		{
			max = Math.max(max, valeur[i]);
		}
		
		
		return max;
	}
	
	public BufferedImage DilatationGris(BufferedImage image){
		BufferedImage image2 = new BufferedImage(image.getWidth(),image.getHeight(),8);
	int	pixel [][] = new int [image.getWidth()][image.getHeight()];
	int	Dilatation [][] = new int [image.getWidth()][image.getHeight()];
	
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
				//valeur [2]= pixel [i+1][j-1];
				valeur [3]= pixel [i-1][j];
				//valeur [4]= pixel [i+1][j];
				valeur [5]= pixel [i-1][j+1];
				//valeur [6]= pixel [i][j+1];
				valeur [7]= pixel [i+1][j+1];
				int max = valeur[0];
				for (int x = 0; x < valeur.length; x++) 
				{
					max = Math.max(max, valeur[x]);
				}
				
				//max = Max(valeur);
				Dilatation[i][j]=max;
				//System.out.println(max);
				int rgb=new Color(max,max,max).getRGB();
				image2.setRGB(i, j, rgb);
				
			}
			
		}
		//System.out.println("Fin max-----------------------------------------------------------------------------------------------"); 
		//System.exit(0);
		return image2;
		//return Dilatation;
		
	}
	
	public BufferedImage DilatationGrisCre(BufferedImage image,int i0,int i1, int i2, int i3){
		BufferedImage image2 = new BufferedImage(image.getWidth(),image.getHeight(),8);
	int	pixel [][] = new int [image.getWidth()][image.getHeight()];
	int	Dilatation [][] = new int [image.getWidth()][image.getHeight()];
	
	int valeur [] = new int [8];
	int max1= 0;
	int some=0;
	
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
				
				int max = valeur[0];
				for (int x = 0; x < valeur.length; x++) 
				{
					max = Math.max(max, valeur[x]);
				}
			
//				Dilatation[i][j]=max;
			 some = max;
			
				//System.out.println(pixel[i][j]);
				//some = Math.min(some, 255);
				int rgb=new Color(some,some,some).getRGB();
				image2.setRGB(i, j, rgb);
				
			}
			
		}
		//System.out.println("Fin max-----------------------------------------------------------------------------------------------"); 
		//System.exit(0);
		return image2;
		//return Dilatation;
		
	}
	public BufferedImage DilatationGrisCinq(BufferedImage image){
		BufferedImage image2 = new BufferedImage(image.getWidth(),image.getHeight(),8);
	int	pixel [][] = new int [image.getWidth()][image.getHeight()];
	int	Dilatation [][] = new int [image.getWidth()][image.getHeight()];
	
	int valeur [] = new int [11];
	
	
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
		
		for (int i = 2; i < image.getWidth()-2; i++) 
		{
			for (int j = 2; j < image.getHeight()-2; j++) {
				valeur [0]= pixel [i][j-2];
				valeur [1]= pixel [i][j-1];
				valeur [2]= pixel [i][j+1];
				valeur [3]= pixel [i][j+2];
				valeur [4]= pixel [i-1][j-1];
				valeur [5]= pixel [i+1][j-1];
				valeur [6]= pixel [i-2][j];
				valeur [7]= pixel [i-1][j];
				valeur [8]= pixel [i+1][j];
				valeur [9]= pixel [i+2][j];
				valeur [10]= pixel [i-1][j+1];
				int max = valeur[0];
				for (int x = 0; x < valeur.length; x++) 
				{
					max = Math.max(max, valeur[x]);
				}
				
				//max = Max(valeur);
				Dilatation[i][j]=max;
				//System.out.println(max);
				int rgb=new Color(max,max,max).getRGB();
				image2.setRGB(i, j, rgb);
				
			}
			
		}
		//System.out.println("Fin max-----------------------------------------------------------------------------------------------"); 
		//System.exit(0);
		return image2;
		//return Dilatation;
		
	}
}
