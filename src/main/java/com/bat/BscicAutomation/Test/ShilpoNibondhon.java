package com.bat.BscicAutomation.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
				.elementToBeClickable(By.xpath(XpathUtils.ShilpoNibondhonModule.registrationSubmittBtn)));
		System.out.println("Registration Page...");
		
		driver = DriverManager.driver;

		//সাধারণ তথ্য
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_name_bangla)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_name_bangla)).sendKeys("টেস্ট প্রতিষ্ঠান ১০ আগস্ট");Thread.sleep(500);
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.project_name)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.project_name)).sendKeys("প্রথম প্রকল্প ");Thread.sleep(500);
		
		Select leave_type = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_type)));
		leave_type.selectByVisibleText("শিক্ষা প্রতিষ্ঠান");Thread.sleep(500);
		
		Select investment_typ = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.investment_type)));
		investment_typ.selectByVisibleText("স্থানীয়");Thread.sleep(500);
		
		Select country = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.investing_country)));
		country.selectByVisibleText("Bangladesh");Thread.sleep(1000);
		
		Select reg_typ = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.reg_type)));
		reg_typ.selectByVisibleText("বিদ্যমান");Thread.sleep(500);
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.totalInvestment)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.totalInvestment)).sendKeys("87890023245 ");Thread.sleep(500);
		
		Select industrialSectorId = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.industrialSector)));
		industrialSectorId.selectByVisibleText("প্রকৌশল শিল্প");Thread.sleep(1000);
		
		Select industrial_sub = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.industrial_sub_sector)));
		industrial_sub.selectByVisibleText("অ্যালুমিনিয়ামের আসবাবপত্র তৈরি");Thread.sleep(500);
		
		System.out.println("সাধারণ তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......"); 
		
		//প্রতিষ্ঠানের কার্যালয়ের ঠিকানা
		
		Select company_office_div = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_office_division)));
		company_office_div.selectByVisibleText("চট্রগ্রাম");Thread.sleep(500);
		
		Select company_office_dis = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_office_district)));
		company_office_dis.selectByVisibleText("কক্সবাজার");Thread.sleep(500);
		
		Select company_office_tha = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_office_thana)));
		company_office_tha.selectByVisibleText("রামু");Thread.sleep(500);
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyOfficePostCode)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyOfficePostCode)).sendKeys("5473 ");Thread.sleep(500);
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyOfficeAddress)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyOfficeAddress)).sendKeys("Office Test Address");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyOfficeEmail)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyOfficeEmail)).sendKeys("company@batworld.com ");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyOfficeMobile)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyOfficeMobile)).sendKeys("01541-801325 ");Thread.sleep(500);
		System.out.println("প্রতিষ্ঠানের কার্যালয়ের ঠিকানা তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......"); 
		
		//প্রতিষ্ঠানের প্রধান নির্বাহী/ব্যবস্থাপনা পরিচালক/কান্ট্রিম্যানেজারের তথ্যা
		
		Select selectDir = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.selectDirectors)));
		selectDir.selectByVisibleText("উদ্যোক্তা/পরিচালক");Thread.sleep(500);	
		
		Select companyCeoNation = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyCeoNationality)));
		companyCeoNation.selectByVisibleText("Australian");Thread.sleep(500);
		
		Select companyCeoNatio = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyCeoNationality)));
		companyCeoNatio.selectByVisibleText("Bangladeshi");Thread.sleep(500);
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyCeoEmail)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.companyCeoEmail)).sendKeys("ceo@batworld.com");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_ceo_father)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_ceo_father)).sendKeys("মোঃ করিম সওদাগর");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_ceo_mob)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_ceo_mob)).sendKeys("01841-801325 ");Thread.sleep(1500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.correspondent_sign)).sendKeys("E:\\browser_download\\sign.png");Thread.sleep(3000);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.cropImageBtn)).click();Thread.sleep(1000);
		 
		System.out.println("প্রতিষ্ঠানের প্রধান নির্বাহী তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......"); 
		
		//নিবন্ধন গ্রহণ করতে ইচ্ছুক কার্যালয়ের নাম
	
		Select pref_reg_of = new Select(driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.pref_reg_off)));
		pref_reg_of.selectByVisibleText("ঢাকা অফিস");Thread.sleep(500);
		System.out.println("নিবন্ধন গ্রহণ করতে ইচ্ছুক কার্যালয়ের নাম তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......"); 
		
		//ক. প্রতিষ্ঠানের কার্যাবলীর তথ্য
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.company_main_work)).sendKeys("Test প্রতিষ্ঠানের প্রধান কার্যাবলীর তথ্য");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.manufacture_starting)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.manufacture_starting)).sendKeys("12-11-2020");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.project_dead)).clear();
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.project_dead)).sendKeys("08-07-2023");Thread.sleep(500);
		System.out.println("প্রতিষ্ঠানের কার্যাবলীর তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......");
		
		//খ. প্রতিষ্ঠানের বার্ষিক উৎপাদন ক্ষমতা 
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.apc_service_name_0)).sendKeys("TesT সেবার নাম");Thread.sleep(500);
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.apc_quantity_0)).sendKeys("121212 Ton");Thread.sleep(500);
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.apc_amount_bdt_0)).sendKeys("50");Thread.sleep(500);
	
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.addServiceIcon)).click();Thread.sleep(1000);
		
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.apc_service_name_3)).sendKeys("TesT সেবার নাম 2");Thread.sleep(500);
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.apc_quantity_3)).sendKeys("657 Ton");Thread.sleep(500);
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.apc_amount_bdt_3)).sendKeys("768");Thread.sleep(500);
		System.out.println("প্রতিষ্ঠানের বার্ষিক উৎপাদন ক্ষমতা তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......");
		
		//গ. বিক্রয় %
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.local_sales_pe)).sendKeys("60");Thread.sleep(500);
		//driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.foreign_sales_pe)).sendKeys("40");Thread.sleep(500);
		System.out.println("বিক্রয় % তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......");
		
		//ঘ. প্রতিষ্ঠানের জনবল 
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.localMale)).sendKeys("60");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.localFemale)).sendKeys("40");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.foreignMale)).sendKeys("60");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.foreignFemale)).sendKeys("40");Thread.sleep(500);
		System.out.println("প্রতিষ্ঠানের জনবল তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......");
		
		//ঙ. প্রয়োজনীয় উপযোগ-সেবার বিবরণ
		
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.services_availability0)).click();Thread.sleep(500);
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability0d)).sendKeys("6");Thread.sleep(500);
		Select d = new Select(driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability0t)));
		d.selectByVisibleText("কিলোমিটার");Thread.sleep(500);
		
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.services_availability1)).click();Thread.sleep(500);
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability1d)).sendKeys("6");Thread.sleep(500);
		Select d1 = new Select(driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability1t)));
		d1.selectByVisibleText("কিলোমিটার");Thread.sleep(500);
		
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.services_availability2)).click();Thread.sleep(500);
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability2d)).sendKeys("6");Thread.sleep(500);
		Select d2 = new Select(driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability2t)));
		d2.selectByVisibleText("কিলোমিটার");Thread.sleep(500);
		
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.services_availability3)).click();Thread.sleep(500);
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability3d)).sendKeys("6");Thread.sleep(500);
		Select d3 = new Select(driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability3t)));
		d3.selectByVisibleText("কিলোমিটার");Thread.sleep(500);
		
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.services_availability4)).click();Thread.sleep(500);
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability4d)).sendKeys("6");Thread.sleep(500);
		Select d4 = new Select(driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability4t)));
		d4.selectByVisibleText("কিলোমিটার");Thread.sleep(500);
		
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.services_availability5)).click();Thread.sleep(500);
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability5d)).sendKeys("6");Thread.sleep(500);
		Select d5 = new Select(driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.services_availability5t)));
		d5.selectByVisibleText("কিলোমিটার");Thread.sleep(500);
		System.out.println("প্রয়োজনীয় উপযোগ-সেবার বিবরণ তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......");
		
		//চ. বিনিয়োগ
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.land)).sendKeys("126");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.building)).sendKeys("2326");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.machinery)).sendKeys("2326");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.others)).sendKeys("236");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.wc)).sendKeys("326");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.exchange)).sendKeys("3226");Thread.sleep(500);
		System.out.println("বিনিয়োগ তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......");
		
		//বিনিয়োগের উৎস
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.ceo_taka_invest)).sendKeys("126");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.ceo_dollar_invest)).sendKeys("2326");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.ceo_loan_country)).sendKeys("Pakistan");Thread.sleep(500);
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.local_loan_taka)).sendKeys("236");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.local_loan_dollar)).sendKeys("326");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.local_loan_country)).sendKeys("Bangladesh");Thread.sleep(500);
		
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.foreign_loan_taka)).sendKeys("236");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.foreign_loan_dollar)).sendKeys("326");Thread.sleep(500);
		driver.findElement(By.id(XpathUtils.ShilpoNibondhonModule.foreign_loan_country)).sendKeys("India");Thread.sleep(500);
		
		//দেশভিত্তিক ঋণের উৎস
		
		Select loan_c = new Select(driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.loan_country0)));
		loan_c.selectByVisibleText("Canada");Thread.sleep(500);
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.loan_org_name0)).sendKeys("236");Thread.sleep(500);
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.loan_amount0)).sendKeys("326");Thread.sleep(500);
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.loan_receive_date0)).clear();
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.loan_receive_date0)).sendKeys("12-11-2020");Thread.sleep(500);
		
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.addLoan)).click();Thread.sleep(1000);
		
		Select loan_ca = new Select(driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.loan_country1)));
		loan_ca.selectByVisibleText("India");Thread.sleep(500);
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.loan_org_name1)).sendKeys("236");Thread.sleep(500);
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.loan_amount1)).sendKeys("326");Thread.sleep(500);
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.loan_receive_date1)).clear();
		driver.findElement(By.name(XpathUtils.ShilpoNibondhonModule.loan_receive_date1)).sendKeys("12-11-2020");Thread.sleep(1500);
		
		System.out.println("বিনিয়োগের উৎস তথ্য ইনপুট দেওয়া সম্পন্ন হয়েছে......");
		
		driver.findElement(By.xpath(XpathUtils.ShilpoNibondhonModule.nextBtn)).click();Thread.sleep(500);
	}

}
