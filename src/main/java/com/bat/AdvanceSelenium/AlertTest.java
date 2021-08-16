package com.bat.AdvanceSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bat.BscicAutomation.Utils.PathUtils;

public class AlertTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\do't click (soft)\\webSoft\\selenium\\slenium-files\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("123");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
		
		//switch to alert
		
		Alert alert = driver.switchTo().alert();
		
		// press ok
		
		alert.accept();
		
		//pres cancle
		
		//alert.dismiss();
		
		// verify alert messege
		
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.accept();
		
		// to send some data into alert box
		
		//driver.switchTo().alert().sendKeys("admin");
		//driver.switchTo().alert().sendKeys("pass123");

	}

}
