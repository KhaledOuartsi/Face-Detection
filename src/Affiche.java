
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.media.Buffer;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;

import com.sun.media.util.BufferToBufferedImage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khaled
 */
public class Affiche {
    public Affiche(){
        
    }
    Player p = null;
    Buffer buf;
    BufferToImage buferToImage;
    BufferedImage image1;
    public BufferedImage affichImage(Player p1){
    	
    	
		FrameGrabbingControl f = (FrameGrabbingControl) p1.getControl("javax.media.control.FrameGrabbingControl");
		buf = f.grabFrame();
		buferToImage = new BufferToImage((VideoFormat) buf.getFormat());
		image1= (BufferedImage) buferToImage.createImage(buf);
	
	

return  image1;
}
    
    
    public Player afficheCam(){
         
        	try {

                         
			Vector v= CaptureDeviceManager.getDeviceList(null);
			CaptureDeviceInfo cam =null;
			for (int i=0;i<v.size();i++){

				CaptureDeviceInfo div= (CaptureDeviceInfo) v.elementAt(i);

				if (div.getName().startsWith("vfw")){
					cam=div;
					break;
				}
				System.out.println(div.getName());
			}
			if(cam==null){
				System.out.println("Y'a pas de cam");
			}
			MediaLocator locator =cam.getLocator();
			p = Manager.createRealizedPlayer(locator);
//			add(p.getVisualComponent());
//			p.start();
			
			
			
			
	    

		} catch (Exception e) {
			// TODO: handle exception
		}
                return p;
    }
}
