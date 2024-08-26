package frontend;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Stripe extends JPanel{
	private int X, Ximage, Y, width, height;
	Timer timer;
	Stripe(int X, int Y, int width, int height, int time, int distance)
	{
		this.X=X;
		this.Y=Y;
		this.Ximage=0;
		this.width=width;
		this.height=height;
		this.setBounds(X, Y, width, height);
		this.setVisible(true);
		this.SetMoveToLeft(time, distance);
	}
	protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
		this.setBounds(X, Y, width, height);
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    
        ImageIcon image;
        Image picture;
         image=new ImageIcon("water.jpg");
         picture = image.getImage();
        g2d.drawImage(picture, Ximage, 0, width, height, this);
        g2d.drawImage(picture, Ximage+width, 0, width, height, this);
       // g2d.drawImage(picture, Ximage+width+width/3, 0, width, height, this);

}
	   public void SetMoveToLeft(int time, int distance)
	    {
	        timer=new Timer(time, e->{Ximage-=distance; 
	        if(Ximage+width<0) {Ximage=0;}
	       // this.setLocation(X, Y);
	        repaint();
	       });
	       
	    }
	   
	   public void MoveToLeft()
	    {
	      
	        timer.start();
	    }
	   public void StopMoveToLeft()
	    {
	      
	        timer.stop();
	    }
	   
	
}
