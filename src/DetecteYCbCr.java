

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khaled
 */
public class DetecteYCbCr {
    public DetecteYCbCr() {
		// TODO Auto-generated constructor stub
	}
 
    public BufferedImage DetecteV(BufferedImage image1){
      
      BufferedImage image2 = new BufferedImage(image1.getWidth(),image1.getHeight(),BufferedImage.TYPE_INT_RGB);
      int ycbcr [] = new int [3];
    // int[] rgb = new int[3];
      
//    //Resize tt -----------------------------------------------------------------
//		BufferedImage imageReduite = new BufferedImage((int)(image1.getWidth()*0.5),(int)( image1.getHeight()*0.5), image1.getType());
//		AffineTransform reduire = AffineTransform.getScaleInstance(0.5, 0.5);
//		int interpolation = AffineTransformOp.TYPE_BICUBIC;
//		AffineTransformOp retaillerImage = new AffineTransformOp(reduire, interpolation);
//		retaillerImage.filter(image1, imageReduite );
//		image1 = imageReduite ;
//		//------------------------------------------------------------------------------
     
     for (int i = 0; i < image1.getWidth(); i++) 
            {
                   for (int j = 0; j < image1.getHeight(); j++) {
                    
                   // recuperer couleur de chaque pixel
                  // Color pixelcolor= new Color(image1.getRGB(i, j));
                    int RVB = image1.getRGB(i, j);
							int r=(RVB>>16)& 0xFF;
							int g=(RVB>>8)& 0xFF;
							int b=(RVB)& 0xFF;
//							int y  = (int)( (0.299   * r) + (0.587   * g) + (0.114   * b));
//					        int cb = b-y;//(int)(-0.16874 * r - 0.33126 * g + 0.50000 * b);
//					        
//							int cr = r-y;//(int)( 0.50000 * r - 0.41869 * g - 0.08131 * b);
							
						//	int Y =(int) ((0.299 * r)+(0.587* g)+(0.114* b));

						   int Cb=(int) (((-0.1687* r)+(-0.3313* g)+(0.5* b))+128);

						  int  Cr=(int) (((0.5* r)+(-0.4187* g)+(-0.0813* b))+128);
							
//							ycbcr[0] = y;
//							ycbcr[1] = cb;
//							ycbcr[2] = cr;
							
							//System.out.println(r+" "+g+" "+b);
						  //((Cb>=85) et (Cb<=135))Et ((Cr>=135) et (Cr<=180))
                if( ((Cb>=85) && (Cb<=135))&& ((Cr>=135) && (Cr<=180))){
//                	  if( ((Cb>=140) && (Cb<=195))&& ((Cr>=140) && (Cr<=165))){
                   
//                 
                  image2.setRGB(i, j, 0xffffffff);
                   }else { 
//                  

                   image2.setRGB(i, j, 0xff000000);
                }
//                   
//                   if (r<p){ r=0;} else r=255;
//                   if (g<p){ g=0;} else g=255;
//                  if (b<p){ b=0;} else b=255;
                  
//                  int rgb=new Color(r,g,b).getRGB(); 
//                    image2.setRGB(i, j, rgb);
                } 
           
          }
    
  return image2;
    }
    
    

    
  
} //Fin class
