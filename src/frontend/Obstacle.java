package frontend;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Obstacle extends JLabel{
	private int X, Ygap, obstacleHeight; // X left up
	private static final int gapHeight=210, obstacleWidth=80;
	Timer timer;
	MainFrame frame;
	boolean obstaclePassed;
	public Obstacle(int obstacleHeight, int time, int distance, Bird bird, MainFrame frame, LinkedList<Obstacle> obstacles, int distObstacles, ScorePanel scorePanel)
	{
		
		this.obstacleHeight=obstacleHeight;
		//this.setBounds(X, 0, obstacleWidth, obstacleHeight);
		 this.setOpaque(false);
		 obstaclePassed=false;
		// this.SetMoveToLeft(time, distance, bird, frame, obstacles, distObstacles, scorePanel);
	}
	
	 @Override
	    protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	        Graphics2D g2d=(Graphics2D) g;
	       
	        ImageIcon image;
	        Image picture;
	         image=new ImageIcon("bambu.png");
	         picture = image.getImage();
	        g2d.drawImage(picture, 0, 0, obstacleWidth, Ygap, this);
	        g2d.drawImage(picture, 0, Ygap+gapHeight, obstacleWidth, obstacleHeight-(Ygap+gapHeight), this);  
	      
	 }
	 
	    public void MoveToLeft( int distance, Bird bird, MainFrame frame, LinkedList<Obstacle> obstacles, int distObstacles, ScorePanel scorePanel)
	    {
	    // timer=new Timer(time, e->{
	    	X-=distance;
	    	 this.setLocation(X, 0);
	    	 if(X+obstacleWidth>=162 && X<230)
	    	 {
	    		 int y1=bird.GetY();
	    		 int y2=y1;
	    		 int radius=bird.GetRadius();
	    		 y1=y1+5-radius;
	    		 y2=y2+5+radius;
	    		 if(y1<=Ygap || y2>=(Ygap+gapHeight))
	    		 {
	    			frame.StopRunning();
	    		 }
	    		 obstaclePassed=false;
	    	 }
	    	 else if (X+obstacleWidth<=162)
	    		 {
	    		 if(obstaclePassed==false)
	    		 {scorePanel.IncrementScore();
	    		 obstaclePassed=true;
	    		 }
	    		 }
	    		 
	    	 if(X<-200)
	    	 {
	    		 Obstacle lastObstacle=obstacles.getLast();
	    		 int XLast=lastObstacle.GetX();
	    		  X=XLast+distObstacles;
	    		 this.setLocation(X, 0);
	    		 obstacles.addLast(this);
	    		 obstacles.removeFirst();
	    	 }
	    		// });

	    }
//	    public void StartMoving()
//	    {
//	    	timer.start();
//	    }
//	    public void StopMoving()
//	    {
//	    	timer.stop();
//	    }
	    
	    public void SetX(int X)
	    {
	    	this.X=X;
	    }
	    
	    public void SetY(int Y)
	    {
	    	this.Ygap=Y;
	    	
	    }
	    
	    public void SetBounds()
	    {
	    	this.setBounds(X, 0, obstacleWidth, obstacleHeight);
	    	
	    }
	    public int GetX() {
	    	return X;
	    	
	    }
	    
	

}
