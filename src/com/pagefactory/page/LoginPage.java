package com.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='userName']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='login']") WebElement loginButton;
	
//	public LoginPage(WebDriver driver)
//	{
//		this.driver = driver;
//	}
	
	public void loginToMercury(String uid, String pwd)
	{
		username.sendKeys(uid);
		password.sendKeys(pwd);
		loginButton.click();
	}
}
