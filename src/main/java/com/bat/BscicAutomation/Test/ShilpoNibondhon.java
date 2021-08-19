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
import com.bat.BscicAutomation.Utils.PathUtils;

@Listeners(TestNGReporting.class)
public class ShilpoNibondhon {

	private WebDriver driver = null;

	@Test
	public void homePageButtonVerifyAndClick() throws InterruptedException {

		driver = DriverManager.driver;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PathUtils.ShilpoNibondhonModule.applicationBtn)));
		System.out.println("Apply Button Present");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.applicationBtn)).click();
		System.out.println("Clicked into shilpo nibondhon aplication button");
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "homePageButtonVerifyAndClick")
	public void goIndustrialRegistrationForm() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(PathUtils.ShilpoNibondhonModule.newApplicationRadioBtn)));
		System.out.println("Dashboard Page...");

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.newApplicationRadioBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.newApplicationNext)).click();

		System.out.println("Clicked to go application page.... ");

	}

	@Test(dependsOnMethods = "goIndustrialRegistrationForm")
	public void industrialRegistrationForm() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(PathUtils.ShilpoNibondhonModule.registrationSubmittBtn)));
		System.out.println("Registration Page...");

		driver = DriverManager.driver;

		// সাধারণ তথ্য

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_name_bangla)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_name_bangla))
				.sendKeys("টেস্ট প্রতিষ্ঠান ১০ আগস্ট");
		Thread.sleep(100);

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.project_name)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.project_name)).sendKeys("প্রথম প্রকল্প ");
		Thread.sleep(100);

		Select leave_type = new Select(driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_type)));
		leave_type.selectByVisibleText("শিক্ষা প্রতিষ্ঠান");

		Select investment_typ = new Select(driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.investment_type)));
		investment_typ.selectByVisibleText("স্থানীয়");

		Select country = new Select(driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.investing_country)));
		country.selectByVisibleText("Bangladesh");

		Select reg_typ = new Select(driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.reg_type)));
		reg_typ.selectByVisibleText("বিদ্যমান");

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.totalInvestment)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.totalInvestment)).sendKeys("87890023245 ");

		Select industrialSectorId = new Select(
				driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.industrialSector)));
		industrialSectorId.selectByVisibleText("প্রকৌশল শিল্প");
		Thread.sleep(500);

		Select industrial_sub = new Select(
				driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.industrial_sub_sector)));
		industrial_sub.selectByVisibleText("অ্যালুমিনিয়ামের আসবাবপত্র তৈরি");

		System.out.println("General informations fiiled......");

		// প্রতিষ্ঠানের কার্যালয়ের ঠিকানা

		Select company_office_div = new Select(
				driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_office_division)));
		company_office_div.selectByVisibleText("চট্রগ্রাম");
		Thread.sleep(500);

		Select company_office_dis = new Select(
				driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_office_district)));
		company_office_dis.selectByVisibleText("কক্সবাজার");
		Thread.sleep(500);

		Select company_office_tha = new Select(
				driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_office_thana)));
		company_office_tha.selectByVisibleText("রামু");

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyOfficePostCode)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyOfficePostCode)).sendKeys("5473 ");

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyOfficeAddress)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyOfficeAddress)).sendKeys("Office Test Address");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyOfficeEmail)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyOfficeEmail)).sendKeys("company@batworld.com");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyOfficeMobile)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyOfficeMobile)).sendKeys("01541-801325 ");
		System.out.println("Portishaner karzaloyer address inputed......");

		// প্রতিষ্ঠানের প্রধান নির্বাহী/ব্যবস্থাপনা পরিচালক/কান্ট্রিম্যানেজারের তথ্যা

		Select selectDir = new Select(driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.selectDirectors)));
		selectDir.selectByVisibleText("উদ্যোক্তা/পরিচালক");

		Select companyCeoNation = new Select(
				driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyCeoNationality)));
		companyCeoNation.selectByVisibleText("Australian");
		Thread.sleep(500);

		Select companyCeoNatio = new Select(
				driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyCeoNationality)));
		companyCeoNatio.selectByVisibleText("Bangladeshi");

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyCeoEmail)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.companyCeoEmail)).sendKeys("ceo@batworld.com");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_ceo_father)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_ceo_father)).sendKeys("মোঃ করিম সওদাগর");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_ceo_mob)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_ceo_mob)).sendKeys("01841-801325 ");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.correspondent_sign))
				.sendKeys("E:\\browser_download\\sign.png");
		Thread.sleep(2000);
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.cropImageBtn)).click();
		Thread.sleep(1000);

		System.out.println("Prodhan nirbahi information inputed......");

		// নিবন্ধন গ্রহণ করতে ইচ্ছুক কার্যালয়ের নাম

		Select pref_reg_of = new Select(driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.pref_reg_off)));
		pref_reg_of.selectByVisibleText("ঢাকা অফিস");
		System.out.println("Registration korte icchukder karzaloyer nam inputed......");

		// ক. প্রতিষ্ঠানের কার্যাবলীর তথ্য
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.company_main_work))
				.sendKeys("Test প্রতিষ্ঠানের প্রধান কার্যাবলীর তথ্য");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.manufacture_starting)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.manufacture_starting)).sendKeys("12-11-2020");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.project_dead)).clear();
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.project_dead)).sendKeys("08-07-2023");
		System.out.println("Protishaner karzabolir tottho inputed......");

		// খ. প্রতিষ্ঠানের বার্ষিক উৎপাদন ক্ষমতা
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.apc_service_name_0)).sendKeys("TesT সেবার নাম");
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.apc_quantity_0)).sendKeys("121212 Ton");
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.apc_amount_bdt_0)).sendKeys("50");

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.addServiceIcon)).click();
		Thread.sleep(1000);

		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.apc_service_name_3)).sendKeys("TesT সেবার নাম 2");
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.apc_quantity_3)).sendKeys("657 Ton");
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.apc_amount_bdt_3)).sendKeys("768");
		System.out.println("barshik utpadon inputed......");

		// গ. বিক্রয় %

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.local_sales_pe)).sendKeys("60");
		// driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.foreign_sales_pe)).sendKeys("40");Thread.sleep(500);
		System.out.println("bikroy % inputed.....");

		// ঘ. প্রতিষ্ঠানের জনবল

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.localMale)).sendKeys("60");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.localFemale)).sendKeys("40");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.foreignMale)).sendKeys("60");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.foreignFemale)).sendKeys("40");
		System.out.println("protishaner jonobol inputed......");

		// ঙ. প্রয়োজনীয় উপযোগ-সেবার বিবরণ

		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.services_availability0)).click();
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability0d)).sendKeys("6");
		Select d = new Select(driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability0t)));
		d.selectByVisibleText("কিলোমিটার");

		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.services_availability1)).click();
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability1d)).sendKeys("6");
		Select d1 = new Select(driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability1t)));
		d1.selectByVisibleText("কিলোমিটার");

		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.services_availability2)).click();
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability2d)).sendKeys("6");
		Select d2 = new Select(driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability2t)));
		d2.selectByVisibleText("কিলোমিটার");

		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.services_availability3)).click();
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability3d)).sendKeys("6");
		Select d3 = new Select(driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability3t)));
		d3.selectByVisibleText("কিলোমিটার");

		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.services_availability4)).click();
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability4d)).sendKeys("6");
		Select d4 = new Select(driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability4t)));
		d4.selectByVisibleText("কিলোমিটার");

		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.services_availability5)).click();
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability5d)).sendKeys("6");
		Select d5 = new Select(driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.services_availability5t)));
		d5.selectByVisibleText("কিলোমিটার");
		System.out.println("Pryojoniy upozug sebar biboron inputed......");

		// চ. বিনিয়োগ
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.land)).sendKeys("126");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.building)).sendKeys("2326");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.machinery)).sendKeys("6000");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.others)).sendKeys("236");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.wc)).sendKeys("326");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.exchange)).sendKeys("3226");
		System.out.println("Biniyug totho inputed......");

		// বিনিয়োগের উৎস

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.ceo_taka_invest)).sendKeys("126");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.ceo_dollar_invest)).sendKeys("2326");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.ceo_loan_country)).sendKeys("Pakistan");

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.local_loan_taka)).sendKeys("236");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.local_loan_dollar)).sendKeys("326");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.local_loan_country)).sendKeys("Bangladesh");

		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.foreign_loan_taka)).sendKeys("236");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.foreign_loan_dollar)).sendKeys("326");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule.foreign_loan_country)).sendKeys("India");

		// দেশভিত্তিক ঋণের উৎস

		Select loan_c = new Select(driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.loan_country0)));
		loan_c.selectByVisibleText("Canada");
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.loan_org_name0))
				.sendKeys("Organization name canada");
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.loan_amount0)).sendKeys("326");
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.loan_receive_date0)).clear();
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.loan_receive_date0)).sendKeys("12-11-2020");

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.addLoan)).click();
		Thread.sleep(1000);

		Select loan_ca = new Select(driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.loan_country1)));
		loan_ca.selectByVisibleText("India");
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.loan_org_name1)).sendKeys("Organization name india");
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.loan_amount1)).sendKeys("326");
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.loan_receive_date1)).clear();
		driver.findElement(By.name(PathUtils.ShilpoNibondhonModule.loan_receive_date1)).sendKeys("12-11-2020");

		System.out.println("Binuyog utso inputed.....");

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule.nextBtn)).click();
		Thread.sleep(2500);

		// ==============================
		// যন্ত্রপাতি ও সরঞ্জামাদির তথ্য
		// ==============================

		// স্থানীয়ভাবে সংগৃহীত/সংগৃহীতব্য

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.nameField)).sendKeys("name 1");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.quantityField)).sendKeys("68");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.ammountField)).sendKeys("1000");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.addField)).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.nameField2)).sendKeys("name 2");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.quantityField2)).sendKeys("234");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.ammountField2)).sendKeys("1000");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.addField)).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.nameField3)).sendKeys("name 3");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.quantityField3)).sendKeys("334");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.ammountField3)).sendKeys("1000");

		// আমদানিকৃত/আমদানিতব্য

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.nameField4)).sendKeys("name 2");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.quantityField4)).sendKeys("234");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.ammountField4)).sendKeys("1000");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.addField2)).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.nameField5)).sendKeys("name 2");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.quantityField5)).sendKeys("234");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.ammountField5)).sendKeys("1000");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.addField2)).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.nameField6)).sendKeys("name 2");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.quantityField6)).sendKeys("234");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.ammountField6)).sendKeys("1000");

		// কাঁচামাল ও মোড়ক উপকরণের বিবরণ

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.quantityField7)).sendKeys("234");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.ammountField7)).sendKeys("6477");

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.quantityField8)).sendKeys("234");
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.ammountField8)).sendKeys("6477");

		// click the next page
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.nextPage)).click();Thread.sleep(3000);

		// ==============================
		// Tab প্রতিষ্ঠানের উদ্যোক্তা/পরিচালকগনের তথ্য
		// ==============================

		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.nextPage2)).click();
		
		// ==============================
		// Tab উদ্যোক্তার পক্ষে আবেদনপত্র জমাদানকারি অনুমোদিত ব্যক্তির তথ্য
		// ==============================
		
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule2.podobi)).sendKeys("Manager");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule2.address)).sendKeys("Dhaka");
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule2.letterImage)).sendKeys("E:\\browser_download\\65.jpg"); Thread.sleep(2000); 
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule2.photo)).sendKeys("E:\\browser_download\\65.jpg"); Thread.sleep(2000); 
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.id(PathUtils.ShilpoNibondhonModule2.crpBtn)));
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule2.crpBtn)).click();Thread.sleep(2000); 
		
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule2.term)).click();
		driver.findElement(By.xpath(PathUtils.ShilpoNibondhonModule2.nxt3)).click();
		
		// ==============================
		// Tab সার্ভিস ফী পেমেন্ট
		// ==============================
		
		
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule2.address2)).sendKeys("Uttara, Dhaka");Thread.sleep(3000); 
		driver.findElement(By.id(PathUtils.ShilpoNibondhonModule2.submit)).click();
	}

}
