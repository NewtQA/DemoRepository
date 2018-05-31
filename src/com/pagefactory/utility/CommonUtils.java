package com.pagefactory.utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class CommonUtils
{
	public static WebDriver driver;
	public static String xlFilePath = "./Testdata/TestData.xlsx";
	public static String sheetName = "Sheet1";
	ExcelApiTest api = null;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	
	public static WebDriver startBrowser(String browserName, String url)
	{
		if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./WebDrivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./WebDrivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./WebDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	public Object[][] testData(String xlFilePath, String sheetName)
	{
		Object[][] excelData =  null;
		api = new ExcelApiTest(xlFilePath);
		
		int rows = api.getRowCount(sheetName);
		int columns = api.getColumnCount(sheetName);
		
		excelData = new Object[rows-1][columns];
		
		for(int i=1; i<rows; i++)
		{
			for(int j=0; j<columns; j++)
			{
				excelData[i-1][j] = api.getCellData(sheetName, j, i);
			}
		}
		
		return excelData;
	}
	
	@BeforeSuite
	public void startReport()
	{		
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./test-output/MercuryReport.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"./extent-config.xml"));
		extent = new ExtentReports();
		extent.setSystemInfo("Environment", "QA");
		extent.attachReporter(htmlReporter);
	}
		
	@AfterMethod
	public void captureStatus(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel("The test method named as "+result.getName()+" is passed", ExtentColor.GREEN));
//			test.pass(MarkupHelper.createLabel(result.getName()+" Test Case Passed", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel("The test method named as "+result.getName()+" is skipped", ExtentColor.YELLOW));
//			test.skip(MarkupHelper.createLabel(result.getName()+" Test Case Skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel("The test method named as "+result.getName()+" is failed", ExtentColor.RED));
//			test.fail(MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		
	}
	 
	@AfterSuite
	public void cleanUp()
	{
	  extent.flush();
	  driver.quit();
	}
	
}