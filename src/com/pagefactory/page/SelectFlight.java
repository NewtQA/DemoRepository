package com.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectFlight {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH,using="//input[@value='Blue Skies Airlines$361$271$7:10']") WebElement depart;
	@FindBy(how = How.XPATH,using="//input[@value='Pangea Airlines$632$282$16:37']") WebElement retrn;
	@FindBy(how = How.XPATH,using="//input[@name='reserveFlights']") WebElement con;
	
	public SelectFlight(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkFlight()
	{
		depart.click();
		retrn.click();
//		Thread.sleep(2000);
		con.click();
	}
	
}
