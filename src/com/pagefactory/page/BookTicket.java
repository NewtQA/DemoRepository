package com.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class BookTicket {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH,using="//input[@name='passFirst0']") WebElement fName; 
	@FindBy(how = How.XPATH,using="//input[@name='passLast0']") WebElement lName;
	@FindBy(how = How.XPATH,using="//select[@name='pass.0.meal']") WebElement meal;
	@FindBy(how = How.XPATH,using="//select[@name='creditCard']") WebElement card;
	@FindBy(how = How.XPATH,using="//input[@name='creditnumber']") WebElement number;
	@FindBy(how = How.XPATH,using="//select[@name='cc_exp_dt_mn']") WebElement exmnt;
	@FindBy(how = How.XPATH,using="//select[@name='cc_exp_dt_yr']") WebElement exyr;
	@FindBy(how = How.XPATH,using="//input[@name='cc_frst_name']") WebElement fsName;
	@FindBy(how = How.XPATH,using="//input[@name='cc_mid_name']") WebElement mName;
	@FindBy(how = How.XPATH,using="//input[@name='cc_last_name']") WebElement lsName;
	@FindBy(how = How.XPATH,using="//input[@name='ticketLess']") WebElement ticket;
	@FindBy(how = How.XPATH,using="//input[@name='ticketLess']") WebElement address;
	@FindBy(how = How.XPATH,using="//input[@name='buyFlights']") WebElement submit;
	
	public BookTicket(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void ticket()
	{
		fName.sendKeys("Muthu");
		lName.sendKeys("Kumar");
		Select M = new Select(meal);
		M.selectByValue("VGML");
		Select C = new Select(card);
		C.selectByValue("IK");
		number.sendKeys("098093485123");
		Select EM = new Select(exmnt);
		EM.selectByVisibleText("09");
		Select EY = new Select(exyr);
		EY.selectByValue("2007");
		fsName.sendKeys("Muthu");
		mName.sendKeys("Kumar");
		lsName.sendKeys("Murugan");
		ticket.click();
		address.click();
//		Thread.sleep(2000);
		submit.click();
	}
}
