package com.ddf.test.LoginTest;
//Author: XYZ

import java.io.IOException;
import java.util.Hashtable;

import com.ddf.utils.TestDataProvider;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.ddf.base.BaseUI_v1;
import com.ddf.base.BaseUI_v2;
import com.ddf.base.BaseUI_v3;
import com.ddf.base.BaseUI_v4;
import com.ddf.base.BaseUI_v5;
import com.ddf.base.BaseUI_v6;
import com.ddf.utils.ExtentReportManager;

public class loginTest_v6 extends BaseUI_v6 {
	ExtentReports report=ExtentReportManager.getReportInstance();
	
	
	@Test(dataProvider="getTestOneData")
	public void testOne(Hashtable<String, String> dataTable) throws InterruptedException, IOException {
		 logger = report.createTest("Test one");
		invokeBrowser("chrome");
		openURL("websiteURL");
		Thread.sleep(1000);
		elementClick("signinBtn_Xpath");
		enterText("usernameTextbox_Xpath",dataTable.get("UserName"));
		System.out.println("Username: dT.get(Col 1)"+dataTable.get("UserName"));
		enterText("passwordTextbox_Xpath",dataTable.get("Password"));
		System.out.println("Username: dT.get(Col 1)"+dataTable.get("Password"));
		elementClick("submit_Id");
		elementClick("createportfolio_Xpath");
		logger.log(Status.PASS,"Test case passed successfully");
		
		//Simulating failure below - its not actual failure 
		//also, image is dummy - we need to implement capturescreenshot function 
		//logger.log(Status.FAIL,"Test case failed");
		//logger.addScreenCaptureFromPath("D:\\worksoft\\screenshot_selenium.png");
		//takeScreenShotOnFailure();

		Thread.sleep(2000);
		tearDown();
	}
	
	/*
	@Test
	public void testOne() throws InterruptedException, IOException {
		 logger = report.createTest("Test one");
		invokeBrowser("chrome");
		openURL("websiteURL");
		elementClick("signinBtn_Xpath");
		enterText("usernameTextbox_Xpath","U S E R N A M E");
		enterText("passwordTextbox_Id","l o n g - p a s s w o r d");
		logger.log(Status.PASS,"Test case passed successfully");
		
		//Simulating failure below - its not actual failure 
		//also, image is dummy - we need to implement capturescreenshot function 
		//logger.log(Status.FAIL,"Test case failed");
		//logger.addScreenCaptureFromPath("D:\\worksoft\\screenshot_selenium.png");
		//takeScreenShotOnFailure();

		Thread.sleep(2000);
		tearDown();
	}
	*/
	@AfterTest
	public void endReport() {
		report.flush();
	}
	
	
	//Below function not working at signin - need to check
	//@Test(dataProvider="getTestOneData")
	
	
	
	@DataProvider
	public Object[][] getTestOneData(){
		return TestDataProvider.getTestData("Rediiflogin.xlsx", "Feature 1", "Test One");
	}
	
}

