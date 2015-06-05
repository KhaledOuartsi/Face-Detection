import java.awt.Color;
import java.awt.image.BufferedImage;


public class CandL {

	public CandL() {
		// TODO Auto-generated constructor stub
	}
	
	
	public BufferedImage cAndL(BufferedImage C, BufferedImage L ,int w,int h,int i0,int i1,int i2,int i3){
		
		
		int valeur ;
		int [][] valeurMulti = new int [w][h];
		
		BufferedImage image2 = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		int [][] c = new int [w][h];
		int [][] l = new int [w][h];
		int max =0;
		//int jmax = 20;
		for (int i = i0; i < i2; i++) 
		{
			for (int j = i1; j < i3; j++) 
			{
				int RVB = C.getRGB(i, j);
				 int r=(RVB>>16)& 0xFF;
				 c[i][j]=r;
			}
		}
		
		for (int i = i0; i < i2; i++) 
		{
			for (int j = i1; j < i3; j++) 
			{
				int RVB = L.getRGB(i, j);
				 int r=(RVB>>16)& 0xFF;
				 l[i][j]=r;
			}
		}
		for (int i = 0; i < i2; i++) {
			for (int j = i1; j < i3; j++) {
				
				valeur = c[i][j]*l[i][j];
				
				max= (int) Math.max(max, valeur);
				valeurMulti[i][j]=  valeur;
				
				
			}
			
		}
		
		for (int i = i0; i < i2; i++) {
			for (int j = i1; j < i3; j++) {
				
				int eyeMap=(int)(valeurMulti[i][j]*255/max);
				
		 int rgb=new Color(eyeMap,eyeMap,eyeMap).getRGB(); 
		 image2.setRGB(i, j, rgb);
				
			}
		}
		
		return image2;
		
		
		
	}
}
