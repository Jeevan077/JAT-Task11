package jattask11;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandling {

	public static void main(String[] args) {
		// Question1
		
		//Launching chrome browser
	    WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.com/chrome/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Navigating to the internet website
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		
		//Clicking the click here button
		driver.findElement(By.partialLinkText("Click Here")).click();
		
		//Switch to newly opened window
		String originalwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		
		//Switch to new window
		for (String WindowHandle : allwindows)
		{
			if (!WindowHandle.equals(originalwindow))
			{
				driver.switchTo().window(WindowHandle);
				break;
			}
		}
		
		//Verifying the text "new Window" is present on the page
		
		if (driver.getPageSource().contains("New Window"))
		{
		System.out.println("The text 'New Window' is Found in the new window");
		}
		else
		{
		System.out.println("Text 'New Window' is not found");
		}
		
		//Closing the new window
		driver.close();
		
		//Switch back to the original window
		driver.switchTo().window(originalwindow);
		System.out.println("Switched back to the original window.");
		
		//Closing the browser instance
		driver.quit();
		
	}

}


/*
//OUTPUT:
The text 'New Window' is Found in the new window
Switched back to the original window.
 */

