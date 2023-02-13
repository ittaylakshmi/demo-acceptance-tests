package com.tradingview.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tradingview.base.TradingViewBase;
import com.tradingview.pages.CurrencyOverviewPage;
import com.tradingview.utils.PageObjectManager;
import com.tradingview.utils.TestContext;

import io.cucumber.java.en.Then;

public class CurrencyOverviewPageStepDefinitions extends TradingViewBase {

	CurrencyOverviewPage currencyoverviewPage;
	TestContext testContext;
	WebDriver driver;
	PageObjectManager pageObjectManager;

	public CurrencyOverviewPageStepDefinitions(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		pageObjectManager = testContext.getPageObjectManager();
		currencyoverviewPage = pageObjectManager.getPoundToYenPage(driver);
	}

	@Then("I verify currency as {string} in rates page")
	public void verifyCurrencyPage(String currency) {
		boolean isCurrencyDisplayed = currencyoverviewPage.verifyCurrency(currency);
		Assert.assertTrue(isCurrencyDisplayed, "Validate currency " + currency + "is loaded correctly");
	}

	@Then("I signout from Trading View Application")
	public void performSignOut() {
		currencyoverviewPage.signOut();
	}
}
