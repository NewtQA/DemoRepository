package com.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class BookFlight {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH,using="//input[@value='oneway']") WebElement type;
	@FindBy(how = How.XPATH,using="//select[@name='passCount']") WebElement passengers;
	@FindBy(how = How.XPATH,using="//select[@name='fromPort']") WebElement departing;
	@FindBy(how = How.XPATH,using="//select[@name='fromMonth']") WebElement onMonth;
	@FindBy(how = How.XPATH,using="//select[@name='fromDay']") WebElement onDate;
	@FindBy(how = How.XPATH,using="//select[@name='toPort']") WebElement arriving;
	@FindBy(how = How.XPATH,using="//select[@name='toMonth']") WebElement returningMonth;
	@FindBy(how = How.XPATH,using="//select[@name='toDay']") WebElement returningDate;
	@FindBy(how = How.XPATH,using="//input[@value='First']") WebElement selectClass;
	@FindBy(how = How.XPATH,using="//select[@name='airline']") WebElement airline;
	@FindBy(how = How.XPATH,using="//input[@name='findFlights']") WebElement submit;
	
//	public BookFlight(WebDriver driver)
//	{
//		this.driver = driver;
//	}
	
	public void flightBook()
	{
		type.click();
		Select P = new Select(passengers);
		P.selectByValue("4");
		Select D = new Select(departing);
		D.selectByValue("London");
		Select om = new Select(onMonth);
		om.selectByValue("3");
		Select od = new Select(onDate);
		od.selectByValue("12");
		Select Ar = new Select(arriving);
		Ar.selectByValue("London");
		Select rm = new Select(returningMonth);
		rm.selectByValue("8");
		Select rd = new Select(returningDate);
		rd.selectByValue("9");
		selectClass.click();
		Select A = new Select(airline);
		A.selectByVisibleText("Pangea Airlines");
//		Thread.sleep(2000);
		submit.click();
		
	}
}
