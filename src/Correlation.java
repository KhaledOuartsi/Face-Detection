import java.awt.image.BufferedImage;

public class Correlation {
	public double cross(BufferedImage image,BufferedImage image2,int min_i,int max_i,int min_j,int max_j){
		
		
		

		
		
		double moy = 0;
		double  moy_1 =0;
		int W = image.getWidth();
		int H = image.getHeight();
		
			for (int i = min_i;i <=max_i; i++){
				for (int j = min_j; j <= max_j; j++) {
				 int rgb = image.getRGB(i, j);
				  
				    int rouge = ((rgb >> 16) & 0xff); 
					   int vert = ((rgb >> 8) & 0xff); 
					    int blue = ((rgb ) & 0xff);
					    double pixel_moy = (blue+vert+rouge)/3;
						moy=moy+pixel_moy;
						 int rgb_1 = image2.getRGB(i, j);

						int blue_1  = ((rgb_1 >> 16) & 0xff);
						int vert_1  = ((rgb_1 >> 8) & 0xff);
						int rouge_1 = ((rgb_1 ) & 0xff);
						double pixel_moy_1 = (blue_1+vert_1+rouge_1)/3;
						moy_1=moy_1+pixel_moy_1;
		    
				 	}
				}
		
			double mult =0;
		double add=0;
		double add_1=0;
		double moyenne_image=moy/(W*H);
		double moyenneimage_1=moy_1/(W*H);
		for (int i = min_i;i <=max_i; i++){
			for (int j = min_j; j <= max_j; j++) {
					
			 int rgb = image.getRGB(i, j);
			  
			    int rouge = ((rgb >> 16) & 0xff); 
				   int vert = ((rgb >> 8) & 0xff); 
				    int blue = ((rgb ) & 0xff);
				    double pixel_c = (blue+vert+rouge)/3;
					double diff=pixel_c-moyenne_image;
					 int rgb_1 = image2.getRGB(i, j);

					int blue_1  = ((rgb_1 >> 16) & 0xff);
					int vert_1  = ((rgb_1 >> 8) & 0xff);
					int rouge_1 = ((rgb_1 ) & 0xff);
					double pixel_c_1 = (blue_1+vert_1+rouge_1)/3;
					double diff_1=pixel_c_1-moyenneimage_1;
					mult =mult+( diff*diff_1);
					add=add+(Math.pow(diff, 2)); 
					add_1=add_1+(Math.pow(diff_1, 2));

	    
				    
			 	}
			}
		double sqrt =Math.sqrt(add);
		double sqrt_1 =Math.sqrt(add_1);
		double mult_1=sqrt*sqrt_1;
		double correlation= mult/mult_1;
		return correlation;

		

			}					
			
	}					


