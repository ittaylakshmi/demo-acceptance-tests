package com.tradingview.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.tradingview.base.TradingViewBase;
import com.tradingview.pages.SigninPage;
import com.tradingview.utils.PageObjectManager;
import com.tradingview.utils.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SigninPageStepDefinitions extends TradingViewBase {

	SigninPage signInPage;
	TestContext testContext;
	WebDriver driver;
	PageObjectManager pageObjectManager;

	public SigninPageStepDefinitions(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		pageObjectManager = testContext.getPageObjectManager();
		signInPage = pageObjectManager.getLoginPage(driver);
	}

	@Given("I attempt to navigate to Trading View signIn page")
	public void tradingViewSignIn() {
		signInPage.navigateToTradingView();
	}

	@When("I attempt to signIn with username as {string} and password as {string}")
	public void performSignIn(String username, String password) throws Exception {
		signInPage.performSignIn(username, password);
	}

}
