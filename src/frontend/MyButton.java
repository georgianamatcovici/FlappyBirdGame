package frontend;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class MyButton extends JButton{

	
	MyButton(int X, int Y, int width, int height, String text)
	{
	    super(text);
		this.setFocusable(false);
        this.setFont(new Font("Arial", Font.BOLD, 30));
	    this.setBounds(X, Y, width, height);
	    this.setBackground(new Color(255, 128, 0));
	    this.setForeground(new Color(255, 255, 204));
	   // button.setContentAreaFilled(false);
	    this.setOpaque(true);
	    this.setBorder(new BevelBorder(BevelBorder.RAISED)); 
	}

}
