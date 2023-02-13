package com.tradingview.utils;

import org.openqa.selenium.WebDriver;
import com.tradingview.pages.CurrencyOverviewPage;
import com.tradingview.pages.RatesAllPage;
import com.tradingview.pages.SigninPage;

public class PageObjectManager {

	SigninPage loginPage;
	RatesAllPage searchPage;
	CurrencyOverviewPage poundToYenPage;

	public SigninPage getLoginPage(WebDriver driver) {
		return loginPage == null ? new SigninPage(driver) : loginPage;
	}

	public RatesAllPage getSearchPage(WebDriver driver) {
		return searchPage == null ? new RatesAllPage(driver) : searchPage;
	}

	public CurrencyOverviewPage getPoundToYenPage(WebDriver driver) {
		return poundToYenPage == null ? new CurrencyOverviewPage(driver) : poundToYenPage;
	}

}
