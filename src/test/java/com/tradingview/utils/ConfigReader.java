package com.tradingview.utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public ConfigReader() {
		try {
			FileReader reader = new FileReader(System.getProperty("user.dir") + "\\config.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error occured while reading properties file...");
		}
	}

	public String getUrl() {
		String url = prop.getProperty("url");
		if (url == null)
			throw new RuntimeException("Cannot find the property url...");
		return url;
	}

	public String getBrowser() {
		String browser = System.getProperty("browser");
		browser = browser == null ? prop.getProperty("browser") : browser;
		if (browser == null)
			throw new RuntimeException("Cannot find the property username...");
		return browser;
	}

}
