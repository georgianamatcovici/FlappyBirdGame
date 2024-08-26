package frontend;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Wing extends JLabel{
	private int X, Y, width, height;
	private Timer timer;
	private boolean isRotated=false;
	Wing(int X, int Y, int width, int height)
	{
		this.X=X;
		this.Y=Y;
		this.width=width;
		this.height=height;
		this.setBounds(X, Y, width, height);
		 this.setOpaque(false);
		 this.SetMove(100);
	}
	
	protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
   
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
       if(isRotated) 
      g2d.rotate(Math.toRadians(25), width, 0);
       // else  g2d.rotate(Math.toRadians(350), width/2, height/2);
        ImageIcon image=new ImageIcon("wings.png");
       Image picture = image.getImage();
       g2d.drawImage(picture, 5, 5, width-5, height-5, this);
  

        g2d.dispose();
	
	}
	
	public void SetMove(int time)
	{
		timer=new Timer(time, e-> {
			if(!isRotated)
				isRotated=true;
			else isRotated=false;
			repaint();
	});
	}
	
	public void Move()
	{
		
		timer.start();	
	}
	
	public void StopMove()
	{
		
		timer.stop();	
	}
	
	
	
	

}
