package com.bat.BscicAutomation.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bat.BscicAutomation.DTO.LoginDTO;
import com.bat.BscicAutomation.DataProvider.LoginDataProvider;
import com.bat.BscicAutomation.Utils.DriverManager;
import com.bat.BscicAutomation.Utils.IdPathUtils;
import com.bat.BscicAutomation.Utils.TestNGReporting;
import com.bat.BscicAutomation.Utils.UrlTextUtils;
import com.bat.BscicAutomation.Utils.XpathUtils;
import java.util.List;


@Listeners(TestNGReporting.class)
public class LoginTest {

	private WebDriver driver = null;

	@Test
	public void homepagetitleverify() {
		driver = DriverManager.driver;
		driver.get(UrlTextUtils.URL.baseUrl);
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.Test.homepageTitle);
		System.out.println("Homepage Title verified");
		driver.findElement(By.xpath(XpathUtils.LoginModule.goLoginPageBtn)).click();
		System.out.println("Login page button clicked.... ");
	}

	@Test(dependsOnMethods = "homepagetitleverify", dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void logintest(List<LoginDTO> logData) {
		for (LoginDTO login : logData) {
			driver.findElement(By.id(IdPathUtils.LoginModule.username)).sendKeys(login.getUsername());
			driver.findElement(By.id(IdPathUtils.LoginModule.nextBtn)).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.id(IdPathUtils.LoginModule.loginBtn)));
			
			driver.findElement(By.id(IdPathUtils.LoginModule.password)).sendKeys(login.getPassword());
			driver.findElement(By.id(IdPathUtils.LoginModule.loginBtn)).click();
			System.out.println("Logged In Successfully");
		}

	}
}
