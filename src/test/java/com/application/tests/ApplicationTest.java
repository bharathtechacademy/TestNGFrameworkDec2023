package com.application.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;

public class ApplicationTest extends BaseTest{
	
	
	@Test(priority=1)
	public void verifyApplicationLogo() {
		loginpage.launchApplication();
		loginpage.verifyApplicationIsLaunchedSuccessfully();
		loginpage.verifyLogo();
	}	
	
	@Test(priority=2)
	public void verifyApplicationCaption() {
		loginpage.launchApplication();
		loginpage.verifyApplicationIsLaunchedSuccessfully();
		loginpage.verifyCaption();
	}
	
	@Test(priority=3)
	public void verifyApplicationLoginPageHeader() {
		loginpage.launchApplication();
		loginpage.verifyApplicationIsLaunchedSuccessfully();
		loginpage.verifyLoginHeader();
	}
	
	@Test(priority=4,dataProvider="testdata")
	public void verifyApplicationLogin(String username, String password) {
		loginpage.launchApplication();
		loginpage.verifyApplicationIsLaunchedSuccessfully();
		loginpage.enterCredentials(username, password);
		loginpage.clickOnLogInButton();
		homepage.verifyLoginIsSuccessful();
	}
	
}
