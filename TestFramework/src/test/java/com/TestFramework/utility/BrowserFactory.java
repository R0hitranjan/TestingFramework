package com.TestFramework.utility;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {
	
	public static WebDriver startApp(WebDriver driver, String browserName, String appURL) {
		
		if(browserName=="Firefox") {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
			driver = new ChromeDriver();
			
		}
		else if(browserName=="Safari") {
			System.setProperty("webdriver.safari.driver", "//usr/bin/safaridriver");
			driver = new SafariDriver();
		}
		else if(browserName=="IE") {
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("This browser is not supported");
		}
		
		driver.manage().window().setPosition(new Point(1350,10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
