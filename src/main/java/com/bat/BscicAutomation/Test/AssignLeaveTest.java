package com.bat.BscicAutomation.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bat.BscicAutomation.Utils.XpathUtils;
import com.bat.BscicAutomation.Utils.DriverManager;
import com.bat.BscicAutomation.Utils.TestNGReporting;
import com.bat.BscicAutomation.Utils.UrlTextUtils;

@Listeners(TestNGReporting.class)
public class AssignLeaveTest {

	private WebDriver driver = null;

	@Test
	public void buttonAndUrlVerify() {

		driver = DriverManager.driver;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.AssignLeaveModule.assignLeaveBtn)));

		driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.assignLeaveBtn)).click();

		Assert.assertEquals(driver.getCurrentUrl(), UrlTextUtils.URL.assignLeavePageUrl);
	}

	@Test(dependsOnMethods = "buttonAndUrlVerify")
	public void assignleavetest() throws InterruptedException {

		driver.findElement(By.id("assignleave_txtEmployee_empName")).sendKeys("Mr. Hello");

		Select leave_type = new Select(driver.findElement(By.id(XpathUtils.AssignLeaveModule.assignLeaveType)));
		leave_type.selectByVisibleText("CAN - Vacation");

		driver.findElement(By.id(XpathUtils.AssignLeaveModule.assignLeaveFrom)).clear();
		driver.findElement(By.id(XpathUtils.AssignLeaveModule.assignLeaveFrom)).sendKeys("2021-11-12");

		driver.findElement(By.id(XpathUtils.AssignLeaveModule.assignLeaveTo)).clear();
		driver.findElement(By.id(XpathUtils.AssignLeaveModule.assignLeaveTo)).sendKeys("2021-11-25");

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.elementToBeClickable(By.id(XpathUtils.AssignLeaveModule.assignLeavePartialDay)));
		driver.findElement(By.className(XpathUtils.AssignLeaveModule.assignLeaveComment)).click();
		Thread.sleep(5000);
		Select partialDay = new Select(driver.findElement(By.id(XpathUtils.AssignLeaveModule.assignLeavePartialDay)));
		partialDay.selectByVisibleText("All Days");

		driver.findElement(By.id(XpathUtils.AssignLeaveModule.assignLeaveComment)).sendKeys("Very Urgent");

		driver.findElement(By.id(XpathUtils.AssignLeaveModule.assignLeaveSubmit)).click();

		System.out.println("Assign leave test success....");
	}

}
