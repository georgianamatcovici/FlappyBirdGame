package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLayeredPane;
import javax.swing.Timer;

import frontend.Bird;
import frontend.MainFrame;
import frontend.Obstacle;
import frontend.ScorePanel;

public class ObstacleGenerator {

    private LinkedList<Obstacle> obstacles;
	private JLayeredPane layeredPane;
	private int  obstacleHeight, xStart, distance;
	private Bird bird;
	private MainFrame frame;
	private ScorePanel scorePanel;
	private Random random;

	public ObstacleGenerator(JLayeredPane layeredPane, int obstacleHeight, int xStart, int distance,
			Bird bird, MainFrame frame, ScorePanel scorePanel)// distance between obstacles
	{ obstacles=new LinkedList<Obstacle>(); //important!!!
		// System.out.println("This is the number!"+number);
//	Random random=new Random();
//	for(int i=0; i<100; i++)
//	{int randomY=random.nextInt(obstacleHeight-50-220-70)+70;
//	Obstacle newObstacle=new Obstacle(xStart, randomY, obstacleHeight);
//	layeredPane.add(newObstacle, Integer.valueOf(2));
//	newObstacle.MoveToLeft(25, 18, bird, frame);
//	xStart-=5;
//	//obstacles.add(newObstacle);
//	lastlastObstacle=lastObstacle;
//	lastObstacle=newObstacle;
//	xStart+=distance;
//	}
		this.layeredPane = layeredPane;
		this.obstacleHeight = obstacleHeight;
		this.xStart = xStart;
		this.distance = distance;
		this.bird = bird;
		this.frame = frame;
		this.scorePanel=scorePanel;
		
		 //random = new Random(); 
		 for (int i = 0; i < 20; i++)
		 { //System.out.println("Obstacle #"+(i+1)+" X: "+xStart);
		 //int randomY =random.nextInt(obstacleHeight - 50 - 220 - 70) + 70; 
		 Obstacle newObstacle = new Obstacle(obstacleHeight, 25, 18, bird, frame, obstacles, distance, scorePanel); 
		 newObstacle.setVisible(false);
		 layeredPane.add(newObstacle,Integer.valueOf(2)); 
		// newObstacle.MoveToLeft(25, 18, bird, frame, obstacles, distance, scorePanel); 
		// xStart -=5; 
		 obstacles.add(newObstacle); 
		// xStart += distance;
		 
		 }
	
	}



	public void GenerateCoordinates()// distance between obstacles
	{ // obstacles=new ArrayList<Obstacle>(); //important!!!
		// System.out.println("This is the number!"+number);
		
		random=new Random();
		int i=0;
	for(Obstacle elem: obstacles)
	{
		elem.SetX(xStart+i*distance);
		i++;
		int randomY =random.nextInt(obstacleHeight - 50 - 220 - 70) + 70; 
		elem.SetY(randomY);
		elem.SetBounds();
		elem.setVisible(true);
		elem.StartMoving();
	}
		
		//timerGenerate.start();
	}
	
//	public void MoveObstacles()
//	{
//		for(Obstacle elem: obstacles)
//		{elem.setVisible(true);
//		elem.StartMoving();
//		}
//	}

	public void StopObstacles() {
		//timerGenerate.stop();
	for(Obstacle elem: obstacles)
	{elem.StopMoving();
	}
	}
	
	public void HideObstacles()
	{
		for(Obstacle elem: obstacles)
		{elem.setVisible(false);
		}
		
	}



//public void MoveObstacles()
//{int index=1;
//	for(Obstacle elem: obstacles)
//	{System.out.println(index);
//	index++;
//		elem.MoveToLeft(25, 18);
//	}
//}

}
