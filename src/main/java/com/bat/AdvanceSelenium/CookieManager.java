package com.bat.AdvanceSelenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieManager {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\do't click (soft)\\webSoft\\selenium\\slenium-files\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://ajkerdeal.com/");

		// capturing all cookies from webApp
		Set<Cookie> cookies = driver.manage().getCookies();

		// getting total size of cookies
		System.out.println("Cookie size is : " + cookies.size());
		System.out.println("------------------------------------");

		// getting information of each cookie
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		System.out.println("------------------------------------");

		// getting a specific cookie info

		String sessionId = driver.manage().getCookieNamed("ASP.NET_SessionId").getValue();
		System.out.println(sessionId);
		System.out.println("------------------------------------");

		// Adding new cookie
		Cookie newcookie = new Cookie("TestCookie", "value123");
		driver.manage().addCookie(newcookie);
		System.out.println(newcookie);
		System.out.println("------------------------------------");
		cookies = driver.manage().getCookies();
		System.out.println("Cookie size is : " + cookies.size());
		System.out.println("------------------------------------");

		//Deleting a single cookie
		driver.manage().deleteCookie(newcookie);
		cookies = driver.manage().getCookies();
		System.out.println("Cookie size is : " + cookies.size());
		System.out.println("------------------------------------");
		
		//Deleting all cookies
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("Cookie size is : " + cookies.size());
		System.out.println("------------------------------------");
	}

}
