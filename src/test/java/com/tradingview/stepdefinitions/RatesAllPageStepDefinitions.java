package com.tradingview.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.tradingview.base.TradingViewBase;
import com.tradingview.pages.RatesAllPage;
import com.tradingview.utils.PageObjectManager;
import com.tradingview.utils.TestContext;

import io.cucumber.java.en.When;

public class RatesAllPageStepDefinitions extends TradingViewBase {

	RatesAllPage searchPage;
	TestContext testContext;
	WebDriver driver;
	PageObjectManager pageObjectManager;

	public RatesAllPageStepDefinitions(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		pageObjectManager = testContext.getPageObjectManager();
		searchPage = pageObjectManager.getSearchPage(driver);
	}

	@When("I navigate to {string} currency rates page")
	public void clickAsiaTab(String country) {
		System.out.println("entered clickAsiaTab method...");
		searchPage.clickRatesCountry(country);
	}

	@When("I search for currency {string}")
	public void searchCurrency(String searchterm) {
		System.out.println("search item is " + searchterm);
		searchPage.performSearch(searchterm);
		// searchPage.clickSeeOverView();
	}

	@When("I see the overview")
	public void seeOverview() {
		searchPage.clickSeeOverView();
	}

}
