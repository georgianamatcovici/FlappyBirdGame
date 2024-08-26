package backend;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import frontend.MainFrame;
import java.io.File;
import java.io.IOException;


public class TakeScreenshot implements ActionListener{
private MainFrame frame;
public TakeScreenshot(MainFrame frame)
{
	this.frame=frame;
}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		//Thread.sleep(1000);
		
		Rectangle contentRect = frame.getContentPane().getBounds();
		
		Rectangle appFrame=new Rectangle(frame.getX() + frame.getInsets().left,
                frame.getY() + frame.getInsets().top,
                contentRect.width, contentRect.height);
     
		try {
			Robot robot = new Robot();
			BufferedImage screenshot = robot.createScreenCapture(appFrame);
			try {
				ImageIO.write(screenshot, "png", new File("window_capture.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

      

      

	}

}
