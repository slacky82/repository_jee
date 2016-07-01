package it.nerd.freetime;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TakeScreenshot {
	
	public static void main(String[] args) throws AWTException, IOException{
		
		Robot awtRobot = new Robot();
		BufferedImage entireScreen = awtRobot.
				createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(entireScreen, "PNG", new File("C:\\Users\\fabrizio\\Desktop\\myScreen.png"));
	}
}
