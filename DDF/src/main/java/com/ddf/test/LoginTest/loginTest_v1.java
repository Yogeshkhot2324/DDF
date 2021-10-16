package com.ddf.test.LoginTest;

import org.testng.annotations.Test;

import com.ddf.base.BaseUI_v1;

public class loginTest_v1 extends BaseUI_v1 {

	@Test
	public void testOne() throws InterruptedException {
		
		invokeBrowser("chrome");
		openURL("https://www.rediff.com/");
		Thread.sleep(1000);
		elementClick("//a[contains(text(),'Sign in')]");
		Thread.sleep(1000);
		enterText("//input[@id='login1']","U S E R N A M E");
		Thread.sleep(2000);
		tearDown();
	}
	
	//Call a different browser - firefox
	@Test(dependsOnMethods="testOne")
	public void testTwo() throws InterruptedException {
		invokeBrowser("firefox");
		openURL("https://money.rediff.com/index.html");
		Thread.sleep(1000);
		elementClick("//a[contains(text(),'Sign In')]");
		Thread.sleep(1000);
		enterText("//input[@id='useremail']","yk");
		Thread.sleep(2000);
		tearDown();
	}
	
	
}
