package com.bat.AdvanceSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\do't click (soft)\\webSoft\\selenium\\slenium-files\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		String mainWindow= driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> iterations=windows.iterator();
		while(iterations.hasNext()) 
		{
			String secondWindow=iterations.next();
			if(!mainWindow.equalsIgnoreCase(secondWindow)) 
			{
				driver.switchTo().window(secondWindow);
				driver.findElement(By.name("emailid")).sendKeys("mymail@gmail.com");Thread.sleep(1000);
				driver.findElement(By.name("btnLogin")).click();Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/p/a")).click();Thread.sleep(2500);
				driver.close();
				System.out.println("Popup page has been managed... ");
				driver.switchTo().window(mainWindow);
				System.out.println("Back to main window...");
			}
			
		}
	}

}
