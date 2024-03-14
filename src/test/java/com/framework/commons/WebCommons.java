package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.BasePage;
import com.framework.base.Reports;
import com.framework.utilities.ReadProp;

public class WebCommons {

	// This class will have all common methods to perform different actions on web application

	public WebDriver driver = new BasePage().getDriver();
	public Properties prop = ReadProp.readData("Config.properties");

	// method to launch the browser
	public void launchApplication(String url) {
		driver.get(url);
	}
	
	//scroll to the element
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
	}
	
	//method to click on element
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}
	
	//method to type the text in textbox
	public void enterInfo(WebElement element, String value) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(value);
	}
	
	
	//method to select checkbox 
	public void selectCheckbox(WebElement element) {
		scrollToElement(element);
		if(!element.isSelected())
			element.click();
	}
	
	//method to wait using java wait 
	public void wait (int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//method to wait using implicit wait
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	//method to wait using implicit wait
	public void waitForElement(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	//method to take screenshot of window
	public static String takeWindowScreenshot(WebDriver driver,String name) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + name + ".jpeg";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}
	
	//method to take screenshot of element
	public static String takeElementScreenshot(WebElement element,String name) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + name + ".jpeg";
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}
	
	//method to get text from element
	public String getText(WebElement element) {
		return element.getText();
	}
	
	//method to get title 
	public String getTitle() {
		return driver.getTitle();
	}
	
	//method to check is element displayed or not
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	//method to print messages
	public void log(String status, String message) {
		if (status.equalsIgnoreCase("info"))
			Reports.logger.info(message);
		else if (status.equalsIgnoreCase("pass"))
			Reports.logger.pass(message);
		else if (status.equalsIgnoreCase("fail"))
			Reports.logger.fail(message);
		else if (status.equalsIgnoreCase("warning"))
			Reports.logger.warning(message);
	}

}
