package com.tradingview.utils;

import org.openqa.selenium.WebDriver;

import com.tradingview.base.TradingViewBase;

public class TestContext {

	private WebDriver driver;
	private TradingViewBase tradingViewBase;
	private PageObjectManager pageObjectManager;

	public TestContext() {
		tradingViewBase = new TradingViewBase();
		driver = tradingViewBase.setUp();
		pageObjectManager = new PageObjectManager();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
}
