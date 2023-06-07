package com.TestFramework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	public Properties prop;
	
	public ConfigDataProvider() {
		
		File src = new File("./Config/Config.properties");
		try {
			FileInputStream fs = new FileInputStream(src);
			prop = new Properties();
			prop.load(fs);
		} catch (Exception e) {
			System.out.println("Unable to Load file"+e.getMessage());
		}
	}
	
	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	
	public String getStagingURL() {
		return prop.getProperty("qaURL");
	}

}
