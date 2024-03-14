package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePage extends Reports {

	private static WebDriver driver = null;

	//method to launch browser
	@BeforeMethod(alwaysRun = true)
	@Parameters(value = "browser")
	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	
	//method to close browser
	@AfterMethod(alwaysRun=true)
	public void tearDownBrowser() {
		driver.quit();
	}
	
	//method to share browser details to other classes
	public WebDriver getDriver() {
		return driver;
	}
	

}
