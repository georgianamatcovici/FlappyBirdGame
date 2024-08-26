package frontend;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;


public class Bird extends JLabel {
	private int Y, Ystart;
	static private final int X=200;
	private int radius;
	private boolean isdown;
	private Timer timerMove, timerFall, timerRotateDown, timerRotateUp;
	private Wing wing;
	private int angle=0;
	
	//private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	Bird(int Y, int radius, MainFrame frame)
	{this.Y=Y;
	this.Ystart=Y;
	this.radius=radius;
	this.isdown=false;
 	this.setBounds(X-radius-20, Y-radius-10, 2*radius+26, 2*radius+29);
	 this.setOpaque(false);
	 this.setLayout(null);
     wing=new Wing(radius/2+5, radius/2+radius, 25, 25);
     wing.setVisible(true);
     this.add(wing);
     this.SetMoveDownAndUp();
     this.SetFall(frame);
     //this.SetRotateUp(1);
     this.SetRotateDown(20);
     
	}
	
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	//this.setBounds(X-radius-50, Y-radius-10, 2*radius+60, 2*radius+35);
   
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.rotate(Math.toRadians(angle), (2*radius+30)/2, (2*radius+35)/2);
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(15, 15, 2*radius, 2*radius);
        g2d.setColor(Color.ORANGE);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawOval(17, 17, 2*radius-1, 2*radius-1);
        g2d.setColor(Color.RED);
        int[] xpoints= {2*radius+15, 2*radius+15, 2*radius+25}; 
        int[] ypoints= {radius+5, radius+25, radius+15};
        g2d.fillPolygon(xpoints, ypoints, 3);
        
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(204, 0, 0));
        g2d.drawLine(2*radius+16, radius+5, 2*radius+25, radius+15);
        g2d.drawLine(2*radius+16, radius+25, 2*radius+25, radius+15);
      
        ImageIcon image;
        Image picture;
         image=new ImageIcon("eye.png");
         picture = image.getImage();
        g2d.drawImage(picture, radius+radius/2+5, radius/2+15, 15, 15, this);
        
        g2d.setColor(new Color(135, 21, 74));
        
        
       

     BasicStroke stroke = new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
     g2d.setStroke(stroke);
        
     g2d.drawLine(15, radius+20, radius+20-radius/2-25, radius+8);
     stroke = new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
     g2d.setStroke(stroke);
     g2d.drawLine(15, radius+20, radius+20-radius/2-25, radius+17);
     stroke = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
     g2d.setStroke(stroke);
     g2d.drawLine(15, radius+20, radius+20-radius/2-25, radius+22);
           
    }
  
    
    public void SetMoveDownAndUp()
    {
    	timerMove=new Timer(400, e->{if(isdown==false) {Y=Y+25; isdown=true;} 
    	else{Y=Y-25; isdown=false;}
    	this.setLocation(X-radius-20, Y-radius-10);}
    	//repaint();}
    	);
    }
    
    public void MoveDownAndUp()
    {
    	
    	timerMove.start();
    }
    
    public void StopMoving()
    {
    	timerMove.stop();
    }
    
    public void SetFall(MainFrame frame)
    {
    	timerFall=new Timer(25, e->{Y=Y+18;
        if(Y+5+36>850) frame.StopRunning();
    	this.setLocation(X-radius-20, Y-radius-10);});
    	
    }
    
    public void Fall()
    { 
    	
    	//repaint();
    	//});
    	timerFall.start();
    	//this.RotateDown(100);
    }
    
    public void StopFalling()
    {
    	timerFall.stop();
    }
    
    public void Rise(int distance)
    {   
    	Y=Y-distance;
    	//angle=345;
    	this.setLocation(X-radius-20, Y-radius-10);
    	//this.RotateUp(100);
    }
    
    public void Fly()
    {
    	wing.Move();
    }
    
    public void StopFly()
    {
    	wing.StopMove();
    }
    
    public void RotateDown()
    {
   
    	timerRotateDown.start();
    }
    
    public void SetRotateDown(int time)
    {
    	timerRotateDown=new Timer(time, e->{
    		if(angle<90) angle+=13;
    		repaint();
    	});
 
    }
    
    public void StopRotateDown()
    {
    	timerRotateDown.stop();
 
    }
    
    
//    public void SetRotateUp(int time)
//    {
//    	timerRotateUp=new Timer(time, e->{
//    	   // if(angle==0) this.Rise(75);
//    		if(angle>-40) 
//    		{
//    			angle-=25;
//    			repaint();
//    		}
//    		else {timerRotateUp.stop();
//    		//scheduler.schedule(this::Fall, 500, TimeUnit.MILLISECONDS);
//    		try {
//				Thread.sleep(50);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//    	this.Fall();
//    	this.RotateDown();
//    		
//    		}
// 
//    	});
//    }
    
    public void RotateUp()
    {
    	
    	//timerRotateUp.start();
    
		//scheduler.schedule(this::Fall, 500, TimeUnit.MILLISECONDS);
    	this.angle=-30;
//		try {
//			Thread.sleep(50);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		this.Rise(75);
	//scheduler.schedule(this::FallRotate, 50, TimeUnit.MILLISECONDS);
	
    	this.Fall();
    	this.RotateDown();
    }
//    public void FallRotate()
//    {
//    	this.Fall();
//    	this.RotateDown();
//    }
    
    public void StopRotateUp()
    {
    	
    	timerRotateUp.stop();
    }
    public int GetY()
    {
    	return this.Y;
    }
  public int GetRadius()
  {
	  return radius;
  }
  
  public void ResetPosition()
  {
	 
	  Y=Ystart;
	  angle=0;
	  //repaint();
	  this.setLocation(X-radius-20, Y-radius-10);
	  repaint();
	  this.setVisible(true);
	  this.Fly();
	
	  
  }
    
  
  
    

	
    

	

}
