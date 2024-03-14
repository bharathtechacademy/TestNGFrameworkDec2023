package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class HomePageElements extends WebCommons {
	
	@FindBy(xpath="//h2[text()='Account Services']")
	protected WebElement accountServices;
	
	protected By accountOverviewPageHeader = By.xpath("//h2[text()='Account Services']");

}
