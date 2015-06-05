import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Carr {
	public Carr(){

	}
	public int [] Line(BufferedImage image1){

		String OuiString = null;
		int [] po=new int [4];
		BufferedImage image2 = new BufferedImage(image1.getWidth(),image1.getHeight(),8);
		int [][] pixel= new int[image1.getWidth()][image1.getHeight()];
		int iMin =0,iMax=0,jMax=0,jMin =0;
		//int[][] position = {{0,0},{0,0}};

		for (int i = 0; i < image1.getWidth(); i++) 
		{
			for (int j = 0; j < image1.getHeight(); j++) 
			{



				pixel[i][j]=image1.getRGB(i, j);
				//System.out.println(pixel[i][j]);
			}
		}
		for (int i = 0; i < image1.getWidth(); i++) 
		{
			for (int j = 0; j < image1.getHeight(); j++) {
				int RVB = image1.getRGB(i, j);
				int r=(RVB>>16)& 0xFF;
				int g=(RVB>>8)& 0xFF;
				int b=(RVB)& 0xFF;
				int valeur = r+b+g;
				//System.out.println(r+" "+g+" "+b+" ");
				//System.out.println(valeur);

				if ((valeur!=0)& (iMin==0)&(jMin==0)){
					iMin=i;
					jMin=j;
				}
				if (valeur!=0) {
					
					if (i<iMin){
						iMin = i;
					}
					if (j<jMin){
						jMin = j;
					}
					if (i>iMax){
						iMax = i;
					}
					if (j>jMax){
					jMax = j;
					}
				
		}
			}
		}
		po[0]= iMin ;
		po[1]=jMin;
		po[2]=iMax;
		po[3]=jMax;
		
		
		return po;
		
		

	}

}
