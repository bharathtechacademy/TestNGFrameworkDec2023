package com.application.steps;

import com.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements {
	
	public void verifyLoginIsSuccessful() {
		waitForElement(accountOverviewPageHeader, 10);
		log("info","Account overview page is displayed");
	}

}
