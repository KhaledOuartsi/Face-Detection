import java.awt.image.BufferedImage;

/**
*
* @author Khaled
*/

public class ConfirmationDesYeux {
	public ConfirmationDesYeux() {
	}



	public boolean TrueFalse(BufferedImage iiiDilate){
		boolean etat = false;
		r R = new r();
		int W=iiiDilate.getWidth();
		int H = iiiDilate.getHeight();
		CCLabeling CC= new CCLabeling(R.Pixel( iiiDilate), W, H);

		int[][] compute = CC.compute();
		int [] labels = R.Elimine(compute, W, H);
		int k1=0;
		int k2=0;
		for (int i = 0; i < labels.length; i++) {

			if ((labels[i]>5)&(labels[i]<200)) {
				k1=i; break;
			}

		}

		for (int i = 0; i < labels.length; i++) {

			if ((labels[i]>5)&(labels[i]<200)&(i!=k1)) {
				k2=i; break;
			}

		}
		if ((labels[k1]!=0)|(labels[k2]!=0)) {
			
			int soustraction = labels[k1]-labels[k2];
			if ((soustraction>-30)|(soustraction<30)) {
				etat=true;
				
			}
		}


		return etat;
	}

}
