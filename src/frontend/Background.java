package frontend;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel{
     private ImageIcon image;
     
     public Background()
     {
    	 image=new ImageIcon("background1.jpg");
     }
     
     @Override
     protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         if (image != null) {
             Image picture = image.getImage();
             g.drawImage(picture, 0, 0, getWidth(), getHeight(), this);
         }
     }
     
}
