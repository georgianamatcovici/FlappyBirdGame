package frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class FinalScore extends JPanel {
	private int X, Y, width, height;
	private int currentScore, highestScore;
    public FinalScore(int X, int Y, int width, int height) {
        this.X=X;
        this.Y=Y;
        this.width=width;
        this.height=height;
        this.setVisible(true);
        this.setOpaque(false);
        this.setBounds(X, Y, width, height);
    }
    public void SetScores(int currentScore, int highestScore)
    {
    	
      //  System.out.println("Scorul citit din fisier este: " + highestScore);
    	  this.highestScore=highestScore;
          this.currentScore=currentScore;
      
    }
    @Override
    protected void  paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	Graphics2D g2d=(Graphics2D) g;
    	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
    	g2d.setColor(Color.BLACK);
        g2d.fillRoundRect(0, 0, width, height, 15, 15);
        g2d.setColor(new Color(255, 229, 204));
        g2d.fillRoundRect(1, 1, width-2, height-2, 15, 15);
        
        g2d.setFont(new Font("Serif", Font.BOLD, 24));
        g2d.setColor(new Color(51, 0, 0));
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
       
        g2d.drawString("Score: ", (width-metrics.stringWidth("String:"))/2, 40);
        g2d.drawString("Best: ", (width-metrics.stringWidth("Best:"))/2, 145);
        //System.out.println("Scorul citit din fisier este: " + highestScore);
        String CurrentScore=Integer.toString(currentScore);
        String HighestScore=Integer.toString(highestScore);
        
        Font font = new Font("Arial", Font.BOLD, 75);
        g2d.setFont(font);
        metrics = g2d.getFontMetrics(g2d.getFont());
        g2d.setFont(font);
        g2d.drawString(CurrentScore, (width-metrics.stringWidth(CurrentScore))/2, 110);
        g2d.drawString(HighestScore, (width-metrics.stringWidth(HighestScore))/2, 215);
        
        
    	
    }
}
