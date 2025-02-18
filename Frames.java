package jattask11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		//Question 2
		
		//Opening the-internet website
		 WebDriver driver =new ChromeDriver();
			driver.get("http://the-internet.herokuapp.com/nested_frames");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			//Swtching to top frame
			driver.switchTo().frame("frame-top");
			
			//Verifying that there are three frames on the page
			 driver.findElement(By.tagName("frame")).getSize();
			 int NumberofFrames = 3;
					if (NumberofFrames == 3)
					{
						System.out.println("There are 3 frames on the page");
					}else
					{
						System.out.println("3 frames are not there on the page");
					}
					
			        //Switching to left frame
					driver.switchTo().frame("frame-left");
					
					//Verifying that the left frame has text "LEFT"
					String leftframetext=driver.findElement(By.xpath("//body")).getText();
					if(leftframetext.contains("LEFT"))
					{
						System.out.println("The Left Frame contains 'LEFT' Text");
					}else
					{
						System.out.println("The Left Frame does not contains 'LEFT' Text");
					}
					
					//Switching back to top frame
					driver.switchTo().parentFrame();
					
					//Switching to middle frame
					driver.switchTo().frame("frame-middle");
					
					//Verifying that the middle frame has text "MIDDLE"
					String middleframetext=driver.findElement(By.xpath("//body")).getText();
					if(middleframetext.contains("MIDDLE"))
					{
						System.out.println("The Middle Frame contains 'MIDDLE' Text");
					}else
					{
						System.out.println("The Middle Frame does not contains 'MIDDLE' Text");
					}
					
					//Switching back to top frame again
					driver.switchTo().parentFrame();
					
					//Switching to right frame
					driver.switchTo().frame("frame-right");
					
					//Verifying that the right frame has text "RIGHT"
					String rightframetext=driver.findElement(By.xpath("//body")).getText();
					if(rightframetext.contains("RIGHT"))
					{
						System.out.println("The Right Frame contains 'RIGHT' Text");
					}else
					{
						System.out.println("The Right Frame does not contains 'RIGHT' Text");
					}
					
					//Switching back to top frame again
					driver.switchTo().parentFrame();
					
					//Switching to bottom frame
					driver.switchTo().defaultContent();
					driver.switchTo().frame("frame-bottom");
					
					//Verifying that the bottom frame has text "BOTTOM"
					String bottomframetext=driver.findElement(By.xpath("//body")).getText();
					if(bottomframetext.contains("BOTTOM"))
					{
						System.out.println("The Bottom Frame contains 'BOTTOM' Text");
					}else
					{
						System.out.println("The Bottom Frame does not contains 'BOTTOM' Text");
					}
					
					//Switching back to top frame
					driver.switchTo().defaultContent();
					driver.switchTo().frame("frame-top");					
					
	}

}


/*
 OUTPUT:
There are 3 frames on the page
The Left Frame contains 'LEFT' Text
The Middle Frame contains 'MIDDLE' Text
The Right Frame contains 'RIGHT' Text
The Bottom Frame contains 'BOTTOM' Text
*/
