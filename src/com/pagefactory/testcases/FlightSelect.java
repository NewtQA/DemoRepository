package com.pagefactory.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pagefactory.page.SelectFlight;
import com.pagefactory.utility.CommonUtils;
import com.pagefactory.utility.RetryFailedTest;

public class FlightSelect extends CommonUtils
{
	@Test(groups = {"booking"}, dependsOnGroups = {"login"}, retryAnalyzer = RetryFailedTest.class)
	public void check()
	{
		test = extent.createTest("check");
		SelectFlight obj = PageFactory.initElements(driver, SelectFlight.class );
		obj.checkFlight();
	}
}
