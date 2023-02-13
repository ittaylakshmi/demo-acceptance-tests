package com.tradingview.utils;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public CommonActions(WebDriver driver) {
		this.driver = driver;
	}

	public void resetImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	public boolean waitTillSpinnerDisappear(WebElement e) {
		resetImplicitWait();
		new FluentWait<>(e).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(100))
				.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.until((Function<WebElement, Boolean>) element -> !element.isDisplayed());
		return true;
	}

	public void doClick(WebElement element) {
		try {
			element.click();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Failed to click an element...");
		}
	}

	public void inputText(WebElement element, String text) {
		try {
			element.click();
			element.sendKeys(text);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Failed to input text into an element...");
		}
	}

	public void mouseHover(WebElement element) {
		try {
			actions = new Actions(driver);
			actions.moveToElement(element).perform();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Failed MouseHover on Element...");
		}
	}

	public void mouseHoverAndClick(WebElement element) {
		try {
			actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Failed MouseHover And click on Element...");
		}
	}

	public void waitForWebElement(WebElement element, int timeout) {
		resetImplicitWait();
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForWebElementAndReturn(WebElement element, int timeout) {
		resetImplicitWait();
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public String extractPageTitle() {
		return driver.getTitle();
	}

	public void waitForPageToLoad(int timeout) {
		int counter = 0;
		String pageLoadStatus = executeJavaScript("return document.readyState");
		while (!pageLoadStatus.equalsIgnoreCase("complete")) {
			if (counter >= timeout)
				break;
			staticWait(1);
		}
	}

	public void staticWait(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String executeJavaScript(String script) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		System.out.println(jse.executeScript(script).toString());
		return jse.executeScript(script).toString();
	}
}
