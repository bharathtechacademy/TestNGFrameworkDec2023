package com.framework.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.base.BasePage;
import com.framework.base.Reports;
import com.framework.commons.WebCommons;

public class TestNGListener extends Reports implements ITestListener {

	public void onTestStart(ITestResult result) {
		startReporing(result.getMethod().getMethodName());
		logger.info(" Test Execution started for test case "+result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.pass(" Test Execution successful for test case "+result.getMethod().getMethodName());
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		logger.fail(" Test Execution Failed for test case "+result.getMethod().getMethodName());
		logger.fail(" Test Execution filed because"+result.getThrowable().getMessage());
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeWindowScreenshot(new BasePage().getDriver(), result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopReporting();
	}

}
