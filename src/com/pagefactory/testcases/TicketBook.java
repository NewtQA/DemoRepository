package com.pagefactory.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pagefactory.page.BookTicket;
import com.pagefactory.utility.CommonUtils;
import com.pagefactory.utility.RetryFailedTest;

public class TicketBook extends CommonUtils
{
	@Test(groups = {"booking"}, dependsOnGroups = {"login"}, retryAnalyzer = RetryFailedTest.class)
	public void ticket()
	{
		test = extent.createTest("ticket");
		BookTicket obj = PageFactory.initElements(driver, BookTicket.class);
		obj.ticket();
	}
}
