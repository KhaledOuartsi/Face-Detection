import java.awt.Color;
import java.awt.image.BufferedImage;

/**
*
* @author Khaled
*/


public class r {

	public r(){
		
	}
	public int max=0;
	public BufferedImage imageK1;
	public BufferedImage imageK2;
	//MainActivity main=new MainActivity();
	
	public int [][] Pixel(BufferedImage image){
		 int pixel[][]= new int [image.getWidth()][image.getHeight()];
		for (int i = 0; i < image.getWidth(); i++) 
		{
			for (int j = 0; j < image.getHeight(); j++) 
			{
				int RVB = image.getRGB(i, j);
				
                 pixel[i][j]=(RVB>>16)& 0xFF;
				//System.out.println(pixel[i][j]);
			}
		}
		
		return pixel;
	}
	
	public BufferedImage ConstruireCouleur(BufferedImage image ,int w,int h,int i0,int i1, int i2, int i3){
		BufferedImage image2 = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

		//int k=0;
//		
		int i=0;
		int j=0;
		for (int x = 0; x < w; x++) 
		{
			for (int y = 0; y < h; y++) {
				
				if ((x >= i0)& (x <= i2)&((y >= i1)&( y < i3))) {
					int RVB = image.getRGB(i, j);
					int r=(RVB>>16)& 0xFF;
					int g=(RVB>>8)& 0xFF;
					int b=(RVB)& 0xFF;
					int rgb=new Color(r,g,b).getRGB(); 
					image2.setRGB(x, y, rgb);
				}else {
					int rgb=new Color(0,0,0).getRGB(); 
					image2.setRGB(x, y, rgb);
					
				}
			}
		}
		
		return image2;
		
	}
	
	
	public BufferedImage Construire(int [][] tab,int [] labels ,int w,int h){
		BufferedImage image2 = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		
//		for (int i = 0; i < image.getWidth(); i++) 
//		 {
//			 for (int j = 0; j < image.getHeight(); j++) {
//				 
//				 max=Math.max(max, tab[i][j]);
//				 
//			 }
//		 }
		int [] lab;
		int k1=0;
		int k2=0;
		for (int i = 0; i < labels.length; i++) {

			if ((labels[i]>700)&(labels[i]<8000)){
				k1=i; break;
			}
		}
		for (int i = 0; i < labels.length; i++) {

			if ((labels[i]>700)&(labels[i]<8000)&(i!=k1)){
				k2=i; break;
			}
		}
		
		for (int i = 0; i < w; i++) 
		 {
			 for (int j = 0; j < h; j++) {
						
			if ((tab[i][j]==k1)|(tab[i][j]==k2)) {
				
				int rgb=new Color(255,255,255).getRGB(); 
				image2.setRGB(i, j, rgb);
			}
			else {
				int rgb=new Color(0,0,0).getRGB(); 
				image2.setRGB(i, j, rgb);
			}
			 }
		 }
		return image2;
		
	}
	
	public BufferedImage ConstruireEye(int [][] tab,int [] labels ,int w,int h){
		BufferedImage image2 = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

		int k=0;
		int l=0;
//		
		for (int i = 0; i < labels.length; i++) {

			if ((labels[i]>5)&(labels[i]<200)){
				k=i; break;
			}
		}
		for (int i = 0; i < labels.length; i++) {

			if ((labels[i]>5)&(labels[i]<200)&(i!=k)){
				l=i; break;
			}
		}
		
		
		for (int x = 0; x < w; x++) 
		{
			for (int y = 0; y < h; y++) {
				
				if ((tab[x][y]==k)|(tab[x][y]==l)) {
					
					int rgb=new Color(255,255,255).getRGB(); 
					image2.setRGB(x, y, rgb);
				}
			}
		}
		
		
		return image2;
		
	}
	// nombre de pixel dans chaque label
	public int[] Elimine(int [][]labels,int w , int h ){
		
		for (int i = 0; i < w; i++) 
			 {
				 for (int j = 0; j < h; j++) {
					 
					 max=Math.max(max, labels[i][j]);
					// System.out.println(max);
				 }
			 }
		int [] some = new int [max];
	//	ArrayList<Integer> arrList = new ArrayList<Integer>(); 
		
		for (int i = 0; i < w; i++) 
		 
			 for (int j = 0; j < h; j++) {
				// int col=(int)(labels[i][j]*255/max); 
				 for (int x=0;x<max;x++)
				 {	 
				 if (labels[i][j]==x) {
					some[x]=some[x]+1;
					
				}
				 
				 }
				 
				 
				 
				 
			 }
//		for (int x=0;x<max/2;x++)
//		{
//			if ((some[x]>450)&(some[x]<1200)) {
//				arrList.add(some[x]);
//			}
//			
//		}
//		System.out.println(arrList.get(0));
//		
		 
			 
		 return some;
		
	}
	
	
	public void EyeTrueFalse(BufferedImage iii,int[]t){
		boolean confirme = false;
		Carr care = new Carr();
		int []tLocal=care.Line(iii);
		int distanceYeux = (int) Math.sqrt((Math.pow((tLocal[2]-tLocal[2]), 2)+ Math.pow((tLocal[1]-tLocal[3]), 2)));
		int distanceVisage = (int) Math.sqrt((Math.pow((t[2]-t[2]), 2)+ Math.pow((t[1]-t[3]), 2)));
		if (distanceVisage!=0) {
			
			float isma =distanceYeux/distanceVisage;
			//System.out.println(distanceYeux+"  visage"+distanceVisage+"  / "+isma);
		}
		
	}
	
	
	public int [] Construire2Label(int [][] tab,int [] labels ,int w,int h){
		imageK1 = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		imageK2 = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Carr Car = new Carr();
        int []careK1 = new int [4];
        int []careK2 = new int [4];
        int []careK12= new int [8];
        
		int k1=0;
		int k2=0;
		//List<Integer> listeK = new LinkedList<Integer>();
//		
		for (int i = 0; i < labels.length; i++) {

			if ((labels[i]>500)&(labels[i]<8000)){
				k1=i; 
				
			}
		}
		for (int i = 0; i < labels.length; i++) {

			if ((labels[i]>500)&(labels[i]<8000)&(i!=k1)){
				k2=i; break;
				
			}
		}
		
		
		
		
		for (int x = 0; x < w; x++) 
		{
			for (int y = 0; y < h; y++) {
				
					if (tab[x][y]==k1) {
						
						int rgb=new Color(255).getRGB(); 
						imageK1.setRGB(x, y, rgb);
					
				}
			}
			
		}
		
		for (int x = 0; x < w; x++) 
		{
			for (int y = 0; y < h; y++) {
				
					if (tab[x][y]==k2) {
						
						int rgb=new Color(255).getRGB(); 
						imageK2.setRGB(x, y, rgb);
					
				}
			}
		}
		careK1= Car.Line(imageK1);
		careK2= Car.Line(imageK2);
		careK12[0]=careK1[0];
		careK12[1]=careK1[1];
		careK12[2]=careK1[2];
		careK12[3]=careK1[3];
		careK12[4]=careK2[0];
		careK12[5]=careK2[1];
		careK12[6]=careK2[2];
		careK12[7]=careK2[3];
		
		
		
		return careK12;
		
	}
	
	
	
	
}
