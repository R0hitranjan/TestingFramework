package com.TestFramework.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.TestFramework.pages.BaseClass;
import com.TestFramework.pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void loginApp() throws InterruptedException {
		
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.loginToCRM(excel.getStringData("Login Details", 0 ,0), excel.getStringData(0, 0, 1));
		
	
	}
	
	
	
	
}	 
 