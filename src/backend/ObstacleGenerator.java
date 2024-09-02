package backend;

import java.util.Iterator;
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
	private int  obstacleHeight, xStart, distance;
	private Random random;
	private Timer timer;

	public ObstacleGenerator(JLayeredPane layeredPane, int obstacleHeight, int xStart, int distance,
			Bird bird, MainFrame frame, ScorePanel scorePanel)// distance between obstacles
	{ obstacles=new LinkedList<Obstacle>(); //important!!!
		this.obstacleHeight = obstacleHeight;
		this.xStart = xStart;
		this.distance = distance;

		 for (int i = 0; i < 15; i++)
		 { 
		 Obstacle newObstacle = new Obstacle(obstacleHeight, 25, 18, bird, frame, obstacles, distance, scorePanel); 
		 newObstacle.setVisible(false);
		 layeredPane.add(newObstacle,Integer.valueOf(2)); 
		 obstacles.add(newObstacle); 
		
		 
		 }
		 
		 timer =new Timer(25, e->{
			 int size=obstacles.size();
				for (int it=0; it<size; it++)
				{  Obstacle elem = obstacles.get(it);
					elem.MoveToLeft(10, bird, frame, obstacles, distance, scorePanel);
					
					
				}
			}
					);
	
	}



	public void GenerateCoordinates()
	{ 
		random=new Random();
		int i=0;
		int size=obstacles.size();
	for(int it=0; it<size; it++)
	{  Obstacle elem = obstacles.get(it);
		elem.SetX(xStart+i*distance);
		i++;
		int randomY =random.nextInt(obstacleHeight - 50 - 220 - 70) + 70; 
		elem.SetY(randomY);
		elem.SetBounds();
		elem.setVisible(true);
		//elem.StartMoving();
	}

		this.StartObstacles();
	
	}
	
	public void StartObstacles() {
		timer.start();
	}
	
	
	public void StopObstacles() {
		timer.stop();
	}
	

	
//
//	public void StopObstacles() {
//		
//	for(Obstacle elem: obstacles)
//	{elem.StopMoving();
//	}
//	}
//	
	public void HideObstacles()
	{
		for(Obstacle elem: obstacles)
		{elem.setVisible(false);
		}
		
	}





}
