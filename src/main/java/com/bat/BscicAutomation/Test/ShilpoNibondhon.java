package com.bat.BscicAutomation.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bat.BscicAutomation.Utils.DriverManager;
import com.bat.BscicAutomation.Utils.TestNGReporting;
import com.bat.BscicAutomation.Utils.UrlTextUtils;
import com.bat.BscicAutomation.Utils.XpathUtils;

@Listeners(TestNGReporting.class)
public class ShilpoNibondhon {

	private WebDriver driver = null;

	@Test
	public void homePageButtonVerifyAndClick() throws InterruptedException {

		driver = DriverManager.driver;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.ShilpoNibondhonModule.applicationBtn)));
		System.out.println("Apply Button Present");
		Thread.sleep(2000);
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.applicationBtn)).click();
		System.out.println("Clicked into shilpo nibondhon aplication button");
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "homePageButtonVerifyAndClick")
	public void goIndustrialRegistrationForm() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(XpathUtils.ShilpoNibondhonModule.newApplicationRadioBtn)));
		System.out.println("Dashboard Page...");

		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.newApplicationRadioBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.newApplicationNext)).click();

		System.out.println("Clicked to go application page.... ");

	}

	@Test(dependsOnMethods = "goIndustrialRegistrationForm")
	public void industrialRegistrationForm() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(XpathUtils.ShilpoNibondhonModule.newApplicationRadioBtn)));
		
		driver = DriverManager.driver;
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.Test.homepageTitle);
		System.out.println("Homepage Title verified");
		
		System.out.println("Registration Page...");

		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.newApplicationRadioBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.newApplicationNext)).click();

		System.out.println("Clicked to go application page.... ");

	}

}
