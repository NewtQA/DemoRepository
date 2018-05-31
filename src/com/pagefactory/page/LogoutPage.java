package com.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogoutPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH,using="//img[@src='/images/forms/Logout.gif']") WebElement logout;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void logoutMercury()
	{
		logout.click();
	}

}
