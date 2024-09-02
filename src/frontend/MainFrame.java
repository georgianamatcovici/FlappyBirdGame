package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import backend.ObstacleGenerator;
import backend.TakeScreenshot;
import backend.UpdateScore;

public class MainFrame extends JFrame  implements MouseListener{
	private int width, height; 
	private Background background;
	private Bird bird;
	private MyButton button, restartButton, exitButton, screenButton;
	private GameTitle title;
	private Stripe stripe;
	private boolean gameStarted=false;
	private boolean firstTap=false;
	private boolean gameStopped=false;
	private  JLayeredPane layeredPane;
	private ObstacleGenerator obstacleGenerator;
	private ScorePanel scorePanel;
	private FinalScore finalScore;
	public void DrawBackground() {
		background=new Background();	
	    background.setSize(width, height);
	    background.setBounds(0, 0, width, height);
	}
	public MainFrame(int width, int height)
	{  this.width=width;
	   this.height=height;
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setResizable(false);
		    this.setUndecorated(true);
		    
		    Toolkit toolkit = Toolkit.getDefaultToolkit();
	        Dimension screenSize = toolkit.getScreenSize();
	        
	        
	        layeredPane=new JLayeredPane();
	        layeredPane.setBounds(0, 0, width, height);
		
		    int x, y;
		    x=screenSize.width/2-this.width/2;
		    y=screenSize.height/2-this.height/2;
		    this.setLocation(x, y);
		 
		    DrawBackground();
		    this.setLayout(null);
		
		    layeredPane.add(background, Integer.valueOf(0));
		    
		    bird = new Bird(550, 25, this);
	        layeredPane.add(bird, Integer.valueOf(3));
	        
	        button=new MyButton(250, 700, 200, 70,"PLAY");
	        button.addActionListener(e->this.StartGame());
		    layeredPane.add(button, Integer.valueOf(2));
		    
		    restartButton=new MyButton(175, 520, 150, 80, "Restart");
		    restartButton.setVisible(false);
		    restartButton.addActionListener(e->this.StartGame());
		    layeredPane.add(restartButton, Integer.valueOf(4));
		    
		    exitButton=new MyButton(370, 520, 150, 80, "Exit");
		    exitButton.setVisible(false);
		    exitButton.addActionListener(e-> System.exit(0));
		    layeredPane.add(exitButton, Integer.valueOf(4));
		    
		    
		    screenButton=new MyButton(220, 650, 250, 80, "Capture Game");
		    screenButton.setVisible(false);
		    screenButton.addActionListener(new TakeScreenshot(this));
		    layeredPane.add(screenButton, Integer.valueOf(4));
		    
		    
		    title=new GameTitle(150, 150, 400, 200);
		    layeredPane.add(title, Integer.valueOf(2));
		    
		    scorePanel=new ScorePanel(290, 50, 150, 110);
			layeredPane.add(scorePanel, Integer.valueOf(4));
			scorePanel.setVisible(false);
			
			stripe=new Stripe(0, 850, 700, 50, 25, 11);
			layeredPane.add(stripe, Integer.valueOf(2));
			stripe.setVisible(false);
			
			finalScore=new FinalScore(225, 100, 250, 250);
			layeredPane.add(finalScore, Integer.valueOf(3));
			finalScore.setVisible(false);
			
			
	 
		    this.add(layeredPane);
		    this.setSize(width, height);
		    this.setVisible(true);
		    this.addMouseListener(this);
		    
		    obstacleGenerator= new ObstacleGenerator(layeredPane, height, 700, 500, bird, this, scorePanel);
		  //  bird.RotateUp(100);
		
	}
	
	public void StartGame()
	{   
		obstacleGenerator.HideObstacles();
		bird.setVisible(false);
		finalScore.setVisible(false);
		restartButton.setVisible(false);
		exitButton.setVisible(false);
		screenButton.setVisible(false);
		scorePanel.SetScore();
		scorePanel.setVisible(true);
		gameStarted=true;
		firstTap=false;
		gameStopped=false;
		button.setVisible(false);
		title.setVisible(false); 
	    stripe.setVisible(true);
		bird.ResetPosition();
		bird.MoveDownAndUp();
		bird.Fly();
		stripe.MoveToLeft();
	   
	 
	}
	
	public void Run()
	{
	
		bird.StopMoving();
		bird.RotateUp();
		//bird.RotateDown();
	    
	     obstacleGenerator.GenerateCoordinates();
	     
		
	}
	
	public void Click()
	{bird.StopFalling();
	bird.StopRotateDown();
	bird.RotateUp();
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(gameStarted==true) 
			if(gameStopped==false)
			{if(firstTap==false){
				this.Run();
		      firstTap=true;
			}
			else this.Click();
					
			}
	}
			
	@Override
	public void mousePressed(MouseEvent e) {
	
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	
	public void StopRunning()
	{
		gameStopped=true;
		obstacleGenerator.StopObstacles();
		bird.StopFalling();
		bird.StopFly();
		bird.StopRotateDown();
		stripe.StopMoveToLeft();
		UpdateScore.Update(scorePanel.GetScore());
		scorePanel.setVisible(false);
		finalScore.SetScores(scorePanel.GetScore(), UpdateScore.GetCurrentScore());
		finalScore.setVisible(true);
		restartButton.setVisible(true);
	    exitButton.setVisible(true);
	    screenButton.setVisible(true);
	}
	
	
	

}
