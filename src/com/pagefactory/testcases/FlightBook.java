package com.pagefactory.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pagefactory.page.BookFlight;
import com.pagefactory.utility.CommonUtils;
import com.pagefactory.utility.RetryFailedTest;

public class FlightBook extends CommonUtils {
	
	@Test(groups = {"booking"}, dependsOnGroups = {"login"}, retryAnalyzer = RetryFailedTest.class)
	public void book()
	{
		test = extent.createTest("book");
		BookFlight book = PageFactory.initElements(driver, BookFlight.class);
		book.flightBook();
	}
}
