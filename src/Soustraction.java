import java.awt.Color;
import java.awt.image.BufferedImage;


public class Soustraction {
	public Soustraction() {
		// TODO Auto-generated constructor stub
	}
	
	public BufferedImage imageSoustraction(BufferedImage imageoriginal,BufferedImage image){
	      BufferedImage image2 = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
	      int RVBThis1;
	      int RVBThis2;
	      int RVBThis3;
	      int RVBThis4;
	      
	      int RVBBack1;
	      int RVBBack2;
	      int RVBBack3;
	      int RVBBack4;
	      int RVB1;
			int r;
			int g;
			int b;
			int niveau1;
			int RVB2;
			int r2;
			int g2;
			int b2;
			int niveau2;
			int somme=0;
			Erosion ero=new Erosion();
			
			int x = image.getHeight()*image.getWidth();
			double valMin =500;
			double valMax =0;
			for (int i = 1; i < image.getWidth()-1; i++) {
				for (int j = 1; j < image.getHeight()-1; j++) {
					
					RVBThis1 = image.getRGB(i, j);
					double  Cr1= (((0.5* ((RVBThis1>>16)& 0xFF))+(-0.418688* ((RVBThis1>>8)& 0xFF)))+(-0.081312* ((RVBThis1)& 0xFF))+128);
					double  Cb1= (((-0.168736* ((RVBThis1>>16)& 0xFF))+(-0.331264* ((RVBThis1>>8)& 0xFF))+(0.5* ((RVBThis1)& 0xFF)))+128);
					//System.out.print(Cr1 + " "+ Cb1);		
					int yEspaceThis1 =  (int)((0.2126 * ((RVBThis1>>16)& 0xFF))+(0.7152* ((RVBThis1>>8)& 0xFF))+(0.0722* ((RVBThis1)& 0xFF)));
					
			
					if (Cr1>valMax)
					{
								
						
						valMax = (int)Cr1;
					}
					if (valMin<Cr1)
					{
						valMin = (int)Cr1;
					}
				}
			}
			
			for (int i = 1; i < image.getWidth()-1; i++) {
				for (int j = 1; j < image.getHeight()-1; j++) {
					
					RVBThis1 = image.getRGB(i, j);
					RVBBack1 = imageoriginal.getRGB(i, j);
					int  Cb1= (int)(((-0.1687* ((RVBThis1>>16)& 0xFF))+(-0.3313* ((RVBThis1>>8)& 0xFF))+(0.5* ((RVBThis1)& 0xFF)))+128);
					int  Cr1= (int)(((0.5* ((RVBThis1>>16)& 0xFF))+(-0.4187* ((RVBThis1>>8)& 0xFF)))+(-0.0813* ((RVBThis1)& 0xFF))+128);
					int  Cr2= (int)(((0.5* ((RVBBack1>>16)& 0xFF))+(-0.4187* ((RVBBack1>>8)& 0xFF)))+(-0.0813* ((RVBBack1)& 0xFF))+128);
					//System.out.println(Cb1 + " "+Cr1 );
					  int val=(int)Math.abs(Cr1-Cr2);
						if (val>10) {
								
							int rgb=new Color(255,255,255).getRGB(); 
								//int rgb=new Color(((RVBThis1>>16)& 0xFF),((RVBThis1>>8)& 0xFF),((RVBThis1)& 0xFF)).getRGB(); 
								image2.setRGB(i, j, rgb);
							
						}
						else {
							int rgb=new Color(0,0,0).getRGB(); 
		                    image2.setRGB(i, j, rgb);
				}
			}
			}
			
			BufferedImage erosion = ero.erosionTrois(image2);
			
			for (int i = 0; i < image.getWidth(); i++) {
				for (int j = 0; j <image.getHeight(); j++) {
				int	RGB = erosion.getRGB(i, j);
				//int	RVBback1 = imageoriginal.getRGB(i, j);
				int RVBThis = image.getRGB(i, j);
					if (((RGB>>16)& 0xFF)==255) {
						int r1=(RVBThis>>16)& 0xFF;
						int g1=(RVBThis>>8)& 0xFF;
						int b1=(RVBThis)& 0xFF;
						int rgb=new Color(r1,g1,b1).getRGB(); 
	                    image2.setRGB(i, j, rgb);
						
						
						
					}else {
						int rgb=new Color(0,0,0).getRGB(); 
						image2.setRGB(i, j, rgb);
						
					}
					
				}
				
			}
			
			
			
			/*
			for (int i = 1; i < image.getWidth()-1; i++) {
				for (int j = 1; j < image.getHeight()-1; j++) {
					RVBThis1 = image.getRGB(i, j);
					RVBThis2 = image.getRGB(i+1, j);
					RVBThis3 = image.getRGB(i, j+1);
					RVBThis4 = image.getRGB(i+1, j+1);
					
					RVBBack1 = imageoriginal.getRGB(i, j);
					RVBBack2 = imageoriginal.getRGB(i+1, j);
					RVBBack3= imageoriginal.getRGB(i, j+1);
					RVBBack4 = imageoriginal.getRGB(i+1, j+1);
					
					r=(RVBThis1>>16)& 0xFF;
					g=(RVBThis1>>8)& 0xFF;
					b=(RVBThis1)& 0xFF;
					// *****************************************************************************
					int yEspaceThis1 =  (int)((0.299 * ((RVBThis1>>16)& 0xFF))+(0.587* ((RVBThis1>>8)& 0xFF))+(0.114* ((RVBThis1)& 0xFF)));
					double yEspaceThis2 =  ((0.299 * ((RVBThis2>>16)& 0xFF))+(0.587* ((RVBThis2>>8)& 0xFF))+(0.114* ((RVBThis2)& 0xFF)));
					double yEspaceThis3 =  ((0.299 * ((RVBThis3>>16)& 0xFF))+(0.587* ((RVBThis3>>8)& 0xFF))+(0.114* ((RVBThis3)& 0xFF)));
					double yEspaceThis4 =  ((0.299 * ((RVBThis4>>16)& 0xFF))+(0.587* ((RVBThis4>>8)& 0xFF))+(0.114* ((RVBThis4)& 0xFF)));
					// *****************************************************************************
					double yEspaceBack1 =  ((0.299 * ((RVBBack1>>16)& 0xFF))+(0.587* ((RVBBack1>>8)& 0xFF))+(0.114* ((RVBBack1)& 0xFF)));
					double yEspaceBack2 =  ((0.299 * ((RVBBack2>>16)& 0xFF))+(0.587* ((RVBBack2>>8)& 0xFF))+(0.114* ((RVBBack2)& 0xFF)));
					double yEspaceBack3 =  ((0.299 * ((RVBBack3>>16)& 0xFF))+(0.587* ((RVBBack3>>8)& 0xFF))+(0.114* ((RVBBack3)& 0xFF)));
					double yEspaceBack4 =  ((0.299 * ((RVBBack4>>16)& 0xFF))+(0.587* ((RVBBack4>>8)& 0xFF))+(0.114* ((RVBBack4)& 0xFF)));
					// *****************************************************************************
					double addThis  = yEspaceThis1+yEspaceThis2+yEspaceThis3+yEspaceThis4;
					double addBack  = yEspaceBack1+yEspaceBack2+yEspaceBack3+yEspaceBack4;
					int Cb1=(int) (((-0.168736* r)+(-0.331264* g)+(0.5* b))+128);

					  int  Cr1=(int) (((0.5* r)+(-0.418688* g)+(-0.081312* b))+128);
					niveau1=(Cb1+Cr1)/2;
					 RVB2 = imageoriginal.getRGB(i, j);
					r2=(RVB2>>16)& 0xFF;
					g2=(RVB2>>8)& 0xFF;
					b2=(RVB2)& 0xFF;	
					int Cb2=(int) (((-0.168736* r)+(-0.331264* g)+(0.5* b))+128);

					  int  Cr2=(int) (((0.5* r)+(-0.418688* g)+(-0.081312* b))+128);
					  double yEspaceBack =  ((0.299 * r2)+(0.587* g2)+(0.114* b2));
					  niveau2=(Cb2+Cr2)/2;
					
					//int val=Math.abs(niveau1-niveau2);
					  int val=(int)Math.abs(addThis-addBack);
					if (val>75) {
//						 int max= Math.max(r,g);
//		                   max=Math.max(max, b);
//		                   int min= Math.min(r,g);
//		                   min=Math.min(min, b);
		               // if(    ((Cb1>=85) && (Cb1<=135))&& ((Cr1>=135) && (Cr1<=180))){
							
							int rgb=new Color((Cb1+Cr1)/2,(Cb1+Cr1)/2,(Cb1+Cr1)/2).getRGB(); 
							image2.setRGB(i, j, rgb);
						//}
					}
					else {
						int rgb=new Color((Cb1+Cr1)/2,(Cb1+Cr1)/2,(Cb1+Cr1)/2).getRGB(); 
	                    image2.setRGB(i, j, rgb);
					}
				}
				
			}*/
			//System.out.println(somme/x);
			

		
		return image2;
	}

}
