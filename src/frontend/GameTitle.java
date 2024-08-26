package frontend;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameTitle extends JPanel{

	private int X, Y, width, height;
	GameTitle(int X, int Y, int width, int height)
	{
		this.X=X;
		this.Y=Y;
		this.width=width;
		this.height=height;
		this.setBounds(X, Y, width, height);
		this.setVisible(true);
	}
	
	  @Override
	    protected void paintComponent(Graphics g) {
	    	super.paintComponent(g);
	   
	        Graphics2D g2d=(Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    
	        ImageIcon image;
	        Image picture;
	         image=new ImageIcon("title (2).png");
	         picture = image.getImage();
	        g2d.drawImage(picture, 0, 0, width, height, this);
	        
	        g2d.setColor(Color.WHITE); 
	        g2d.setFont(new Font("Arial", Font.BOLD, 40));
	        g2d.drawString("Flappy Bird", 90, 75);
	        g2d.drawString("Game", 140, 130);
	
	        g2d.dispose();
	     
	       
	    }

	
	
}
