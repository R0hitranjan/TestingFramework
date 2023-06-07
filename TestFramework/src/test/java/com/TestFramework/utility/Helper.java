package com.TestFramework.utility;

import org.openqa.selenium.WebDriver;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Helper {
	
	//Screenshots,alerts,sync issues, frames, windows, Javascript executor
	
	public static void captureScreenshot(WebDriver driver) {
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshots/capture_"+getCurrentDateTime()+".png"));
		} catch (Exception e) {
			System.out.println("unable to take a screenshot "+e.getMessage());
		} 
	}
	
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		String formattedDate = customFormat.format(currentDate);
		return formattedDate;
	}

}
