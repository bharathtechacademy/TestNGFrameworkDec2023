package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements{
	
	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void launchApplication() {
		launchApplication(prop.getProperty("url"));
	}
	
	public void verifyApplicationIsLaunchedSuccessfully() {
		Assert.assertEquals(getTitle(), prop.getProperty("title"));
		log("info","Application launched Successfully");
		wait(2);
	}
	
	public void verifyLogo() {
		Assert.assertTrue(isDisplayed(logo));
		log("info","Application Logo Displayed Successfully");
	}
	
	public void verifyCaption() {
		Assert.assertEquals(getText(caption), prop.getProperty("caption"));
		log("info","Application Caption Displayed Successfully");
	}
	
	public void verifyLoginHeader() {
		Assert.assertEquals(getText(loginPageHeader), prop.getProperty("header"));
		log("info","Application login page header displayed correctly");
	}
	
	public void enterCredentials(String username,String password) {
		enterInfo(usernameTxtb, username);
		enterInfo(passwordTxtb, password);
		log("info","Credentials entered are "+username+" , "+password);
	}
	
	public void clickOnLogInButton() {
		click(loginBtn);
		log("info","Clicked on Login button");
	}
	
	public void clickOnRegistrationLink() {
		click(registrationLink);
		log("info","Clicked on Registration link");
	}	

}
