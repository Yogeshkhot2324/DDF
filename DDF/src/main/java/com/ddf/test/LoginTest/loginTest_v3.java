package com.ddf.test.LoginTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ddf.base.BaseUI_v1;
import com.ddf.base.BaseUI_v2;
import com.ddf.base.BaseUI_v3;
import com.ddf.utils.ExtentReportManager;

public class loginTest_v3 extends BaseUI_v3 {
	//ExtentReports report=ExtentReportManager.getReportInstance();
	
	@Test
	public void testOne() throws InterruptedException, IOException {
		

		 logger = report.createTest("Test one");
		logger.log(Status.INFO, "Initializing the browser");
		invokeBrowser("chrome");

		logger.log(Status.INFO, "Opening URL");
		openURL("websiteURL");
		logger.log(Status.INFO, "Clicking sign in button");
		//click on the sign in link - xpath defined in obj. repo.
		//sometimes signin takes a longer time and 
		//it may timeout - if it times out, run once again 
		elementClick("signinBtn_Xpath");
		
		enterText("usernameTextbox_Xpath","U S E R N A M E");
		//logger.log(Status.PASS,"Test case passed successfully");
		
		//Simulating failure below - its not actual failure 
		//also, image is dummy - we need to implement capturescreenshot function 
		//logger.log(Status.FAIL,"Test case failed");
		takeScreenShotOnFailure();
		logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "//DDF//ScreenShots//Sat_Oct_09_15_59_02_IST_2021.png");
		//takeScreenShotOnFailure();

		logger.log(Status.INFO, "Navigating back to home page");
		driver.navigate().back();

		logger.log(Status.INFO, "Creating Account");
		elementClick("createAccount");
		

		logger.log(Status.INFO, "Enter full name");
		enterText("fullName","yogesh");
		Thread.sleep(2000);
		tearDown();
	}
	
	@AfterTest
	public void endReport() {
		report.flush();
	}
	
	//@Test(dependsOnMethods="testOne")
	public void testTwo() {
		invokeBrowser("chrome");
		openURL("websiteURL");
		
		//openURL("https://money.rediff.com/index.html");
		//test code to show next function usage - above code not changed to use properties file 
		tearDown();
	}
	
	//@Test(dependsOnMethods="testTwo")
	
	public void testThree() {
		invokeBrowser("chrome");
		//openURL("https://shopping.rediff.com/");
		//test code to show next function usage - above code not changed to use properties file
		tearDown();
		
		// login  - search - add to cart - address - payment - pay  
	}
}
