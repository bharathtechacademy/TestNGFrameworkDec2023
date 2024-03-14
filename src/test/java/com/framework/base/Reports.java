package com.framework.base;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	
	public static ExtentHtmlReporter html = null; //white paper
	public static ExtentReports extent = null; //printer
	public static ExtentTest logger = null; //colors
	
	@BeforeSuite(alwaysRun=true)
	public static void setupReport() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\AutomationReport.html");//generate empty html report
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	
	public static void startReporing(String testcase) {
		logger = extent.createTest(testcase);
	}
	
	public static void stopReporting() {
		extent.flush();
	}

}
