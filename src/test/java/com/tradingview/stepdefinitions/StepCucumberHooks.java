package com.tradingview.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.tradingview.utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class StepCucumberHooks {

	TestContext testContext;
	WebDriver driver;

	public StepCucumberHooks(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
	}

	@Before
	public void beforeSetUpLogin() throws Exception {
		System.out.println("before executing the scenario...");
	}
	
	@After(order = 1) // Cucumber After Hook with order 1
	public void takeScreenShotOnFailedScenario(Scenario scenario) {

		System.out.println("This is from After hook, order=1");
		if ((scenario.isFailed())) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

	@After(order=0)
	public void tearDown() {
		System.out.println("quiting the browser...");
		driver.quit();
	}

	
}
