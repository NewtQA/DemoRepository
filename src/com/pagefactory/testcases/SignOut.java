package com.pagefactory.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pagefactory.page.LogoutPage;
import com.pagefactory.utility.CommonUtils;
import com.pagefactory.utility.RetryFailedTest;

public class SignOut extends CommonUtils
{
	@Test(groups = {"logout"}, dependsOnGroups = {"booking"}, retryAnalyzer = RetryFailedTest.class)
	public void logout()
	{
		test = extent.createTest("logout");
		LogoutPage obj = PageFactory.initElements(driver, LogoutPage.class);
		WebElement con = driver.findElement(By.xpath("//font[@size='+1']")); 
		Assert.assertTrue(con.isDisplayed());
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/Flight_Ticket.png"));
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		obj.logoutMercury();
	}
}
