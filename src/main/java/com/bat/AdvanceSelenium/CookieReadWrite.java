package com.bat.AdvanceSelenium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieReadWrite {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\do't click (soft)\\webSoft\\selenium\\slenium-files\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		// write cookie

		File fileCreate = new File("D:\\BAL_OCPL\\testing_file\\cookie\\cookie.txt");
		try {
			fileCreate.delete();
			fileCreate.createNewFile();

			FileWriter filewriter = new FileWriter(fileCreate);
			BufferedWriter buferwrite = new BufferedWriter(filewriter);

			for (Cookie cookie : driver.manage().getCookies()) {
				buferwrite.write(cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";"
						+ cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure());
				buferwrite.newLine();
			}
			buferwrite.close();
			filewriter.close();
			System.out.println("cookie write operation successfully done........");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// read saved cookie

		try {
			File fileread = new File("D:\\BAL_OCPL\\testing_file\\cookie\\cookie.txt");

			FileReader filereader = new FileReader(fileread);
			BufferedReader buferreader = new BufferedReader(filereader);

			String strline;

			while ((strline = buferreader.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(strline, ";");
				while (token.hasMoreTokens()) {

					String name = token.nextToken();
					String value = token.nextToken();
					String domain = token.nextToken();
					String path = token.nextToken();
					Date expiry = null;

					String val;
					if (!(val = token.nextToken()).equals("null")) {
						String desiredDate = "Sun jan 17 23:59:59 IST 2021";
						DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
						expiry = df.parse(desiredDate);
					}

					Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
					Cookie newcookie = new Cookie(name, value, domain, path, expiry, isSecure);
					System.out.println(newcookie);
					driver.manage().addCookie(newcookie);
					driver.manage().getCookies();
					System.out.println("cookie read operation successfully done........");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

}
