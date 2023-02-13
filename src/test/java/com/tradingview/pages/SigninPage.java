package com.tradingview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tradingview.utils.CommonActions;

public class SigninPage extends CommonActions {
	WebDriver driver;

	public SigninPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[@type='button'])[1]")
	public WebElement humanIcon;

	@FindBy(xpath = "//button[@data-name='header-user-menu-sign-in']")
	public WebElement signInLink;

	@FindBy(xpath = "//div[@class='i-clearfix']")
	public WebElement emailBtn;

	@FindBy(xpath = "//input[@name='username']")
	public WebElement userName;

	@FindBy(css = "input[name='password']")
	public WebElement passWord;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement signInSubmitbtn;

	public void clickHumanIcon() {
		waitForWebElement(humanIcon, 30);
		doClick(humanIcon);
	}

	public void clickSignInLink() {
		doClick(signInLink);
	}

	public void clickEmailBtn() {
		doClick(emailBtn);
	}

	public void clickSignInButton() {
		doClick(signInSubmitbtn);
	}

	public void navigateToTradingView() {
		clickHumanIcon();
		clickSignInLink();
		clickEmailBtn();
	}

	public void performSignIn(String usr, String pwd) {
		inputText(userName, usr);
		inputText(passWord, pwd);
		clickSignInButton();
		waitForPageToLoad(2);
	}

}
