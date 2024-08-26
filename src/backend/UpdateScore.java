package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateScore {
    private static int currentScore;
    public static void ReadScore()
    {

		try {
			FileReader file=new FileReader("HighestScore.txt");
			BufferedReader reader=new BufferedReader(file);
			String line;
			try {
				line = reader.readLine();
		   currentScore = Integer.parseInt(line);

	  
			} catch (IOException e) {
			
				e.printStackTrace();
			}
      
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
    }
    
    public static void WriteScore(int score)
    {

	
			FileWriter file;
			try {
				file = new FileWriter("HighestScore.txt");
				try (BufferedWriter writer = new BufferedWriter(file)) {
					System.out.println("Write: "+score);
					writer.write(Integer.toString(score));
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		
		
    }
    
    public static int GetCurrentScore()
    {
    	
    	ReadScore();
        //System.out.println("Scorul citit din fisier este: " + currentScore);
    	return currentScore;
    }
    
    
	public static void Update(int score)
	{
//		 try (BufferedReader reader = new BufferedReader(new FileReader("/HighestScore"))) {
//	            String line = reader.readLine();
//	            int currentScore = Integer.parseInt(line);
//	            System.out.println("Scorul citit din fisier este: " + currentScore);
//	        } catch (IOException | NumberFormatException e) {
//	            e.printStackTrace();
//	        }
  
          ReadScore();
         if(score>currentScore) WriteScore(score);
	
		
		
	
		//BufferedReader reader = new BufferedReader(new FileReader("HighestScore")); 
			
		
		
		
	}

}
