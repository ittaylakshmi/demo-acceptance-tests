package com.tradingview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tradingview.utils.CommonActions;

public class RatesAllPage extends CommonActions {

	public Actions actions;
	WebDriver driver;

	public RatesAllPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Search']")
	public WebElement searchBoxClick;

	@FindBy(xpath = "//input[@name='query']")
	public WebElement searchInputForData;

	@FindBy(css = ".description-DPHbT8fH")
	public WebElement gbpjpyMenu;

	@FindBy(xpath = "//button[text()='See overview']")
	public WebElement seeOverView;

	@FindBy(xpath = "//div[contains(@class,'tv-spinner')]")
	public WebElement spinner;

	public void clickRatesCountry(String country) {
		waitTillSpinnerDisappear(spinner);
		WebElement countryElement = waitForWebElementAndReturn(fetchRatesCountry(country), 30);
		doClick(countryElement);
	}

	public WebElement fetchRatesCountry(String country) {
		String xpath = "//div[text()='" + country + "']";
		return driver.findElement(By.xpath(xpath));
	}

	public void performSearch(String searchTerm) {
		waitTillSpinnerDisappear(spinner);
		waitForWebElement(searchBoxClick, 30);
		searchBoxClick.click();
		waitForWebElement(searchInputForData, 30);
		inputText(searchInputForData, searchTerm);
	}

	public void clickSeeOverView() {
		mouseHover(gbpjpyMenu);
		mouseHoverAndClick(seeOverView);
		waitTillSpinnerDisappear(spinner);
	}

}
