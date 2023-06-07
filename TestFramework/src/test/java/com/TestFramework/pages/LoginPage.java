package com.TestFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	//Locating Webelements using Testng annotations(recommended when using POM) 
	
	@FindBy(id="inputUsername") WebElement username;
	@FindBy(name="inputPassword") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement loginButton;
	
	public void loginToCRM(String uname, String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		loginButton.click();
	}
}

//POM using page factory
