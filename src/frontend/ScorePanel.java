package frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel{
	private int X, Y, width, height;
	private int score;
    public ScorePanel(int X, int Y, int width, int height) {
        this.X=X;
        this.Y=Y;
        this.width=width;
        this.height=height;
        score = 0;
        
        this.setVisible(true);
        this.setOpaque(false);
 
        this.setBounds(X, Y, width, height);
        this.setLocation(X, Y);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       

        Font font = new Font("Arial", Font.BOLD, height);
        g2d.setFont(font);
        
        String scoreString=Integer.toString(score);
        FontMetrics fm = g2d.getFontMetrics();
        int x = (width - fm.stringWidth(scoreString)) / 2;
        int y = (height - fm.getHeight()) / 2 + fm.getAscent();
        
        g2d.setColor(Color.BLACK);  
        g2d.drawString(scoreString, x - 1, y - 1);
        g2d.drawString(scoreString, x - 1, y + 1);
        g2d.setColor(Color.WHITE);
     
        g2d.drawString(scoreString, x + 1, y - 1);
        g2d.drawString(scoreString, x + 1, y + 1);
        
        g2d.setColor(new Color(51, 255, 153));
        g2d.drawString(scoreString, x, y);
    }
    
    public void IncrementScore()
    {
    	score++;
    	repaint();
    }
    public void SetScore()
    {
    	score=0;
    }
    public int GetScore()
    {
    	return score;
    }


}
