package com.tradingview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tradingview.utils.CommonActions;

public class CurrencyOverviewPage extends CommonActions {

	public Actions actions;
	WebDriver driver;

	public CurrencyOverviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='British Pound / Japanese Yen']")
	public WebElement pageText;

	@FindBy(css = "button[class*='logged']")
	public WebElement openUserMenuBtn;

	@FindBy(css = "button[data-name*='header-user-menu-sign-out']")
	public WebElement signOutBtn;

	public boolean verifyPoundToYenPage() {
		waitForWebElement(pageText, 45);
		return pageText.isDisplayed();
	}

	public boolean verifyCurrency(String currency) {
		try {
			WebElement currencyElement = waitForWebElementAndReturn(fetchCurrency(currency), 10);
			return currencyElement.isDisplayed();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void clickUserMenuBtn() {
		waitForWebElement(openUserMenuBtn, 30);
		doClick(openUserMenuBtn);
	}

	public void clickSignOut() {
		doClick(signOutBtn);
	}

	public void signOut() {
		clickUserMenuBtn();
		clickSignOut();
	}

	public WebElement fetchCurrency(String currency) {
		String xpath = "//h1[contains(text(),'" + currency + "')]";
		return driver.findElement(By.xpath(xpath));
	}

}
