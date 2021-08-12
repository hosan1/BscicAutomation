package com.bat.AdvanceSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\do't click (soft)\\webSoft\\selenium\\slenium-files\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/yahoo.html");
		
		WebElement downloadBtn= driver.findElement(By.id("messenger-download"));
		String sourceUrl=downloadBtn.getAttribute("href");
		
		String wgetCommand= "cmd /c C:\\\"Program Files (x86)\"\\GnuWin32\\bin\\wget.exe -P D:\\BAL_OCPL\\testing_file\\downloadTestFile --no-check-certificate " + sourceUrl;

		try {
			Process execution=Runtime.getRuntime().exec(wgetCommand);
			System.out.println("File Successfully Downloded... ");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
