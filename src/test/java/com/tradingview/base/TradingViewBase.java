package com.tradingview.base;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tradingview.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TradingViewBase {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public static Logger log;
	ConfigReader configReader = new ConfigReader();

	public WebDriver setUp() {

		log = LogManager.getLogger(TradingViewBase.class);

		String browser = configReader.getBrowser();
		if (browser.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().create();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = WebDriverManager.edgedriver().create();
			driver.manage().window().maximize();
		} 
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		getUrl();
		return driver;
	}
	
	
	public void getUrl() {
		driver.get(configReader.getUrl());
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

}
