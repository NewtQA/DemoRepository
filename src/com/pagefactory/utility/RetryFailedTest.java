package com.pagefactory.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

	int count = 1;
	int maxRetryCount = 2;
	
	@Override
	public boolean retry(ITestResult result) {

		if(count < maxRetryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
