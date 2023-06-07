package com.TestFramework.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.TestFramework.utility.BrowserFactory;
import com.TestFramework.utility.ConfigDataProvider;
import com.TestFramework.utility.ExcelDataProvider;
import com.TestFramework.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApp(driver, config.getBrowser(), config.getStagingURL());
		
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE || result.getStatus()==ITestResult.SUCCESS) {
			Helper.captureScreenshot(driver);
		}
	}

}
