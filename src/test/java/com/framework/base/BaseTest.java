package com.framework.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.application.steps.HomePageSteps;
import com.application.steps.LoginPageSteps;
import com.application.steps.RegistrationPageSteps;
import com.framework.utilities.ReadExcel;


public class BaseTest extends BasePage{

	public LoginPageSteps loginpage = null;
	public HomePageSteps homepage = null;
	public RegistrationPageSteps regpage = null;
	
	
	@BeforeMethod(alwaysRun=true, dependsOnMethods="launchBrowser" )
	public void initializePageClassesWithDriver() {
		WebDriver driver = new BasePage().getDriver();
		loginpage = new LoginPageSteps(driver);
		homepage = new HomePageSteps(driver);
		regpage = new RegistrationPageSteps(driver);		
	}
	
	@DataProvider(name="testdata")
	public String [][] testData(Method method){
		String [][] data = ReadExcel.readData("TestData.xlsx", method.getName());
		return data;
	}


}
