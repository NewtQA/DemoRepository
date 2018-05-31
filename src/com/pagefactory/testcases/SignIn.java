package com.pagefactory.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pagefactory.page.LoginPage;
import com.pagefactory.utility.CommonUtils;
import com.pagefactory.utility.ExcelDataConfig;
import com.pagefactory.utility.RetryFailedTest;

public class SignIn extends CommonUtils {
	
	@Parameters({"browser"})
	@Test(groups={"login"},retryAnalyzer = RetryFailedTest.class)
	public void checkUser(String browser)
	{
		test = extent.createTest("checkUser");
		ExcelDataConfig excel = new ExcelDataConfig(xlFilePath);
		WebDriver driver = CommonUtils.startBrowser(browser, excel.signIn(0, 1, 0));
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginToMercury(excel.signIn(0, 1, 1), excel.signIn(0, 1, 2));
	}
	
	@Test(dataProvider = "Credentials", retryAnalyzer = RetryFailedTest.class)
	public void validateUser(String url, String username, String password)
	{
		test = extent.createTest("validateUser");
		WebDriver driver = CommonUtils.startBrowser("chrome", url);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginToMercury(username, password);
		driver.quit();
	}
	
	@DataProvider(name="Credentials")
	public Object[][] checkUserData()
	{
		Object[][] data = testData(xlFilePath, sheetName);
		return data;
	}

}
