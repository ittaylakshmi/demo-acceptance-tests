package com.tradingview.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(
		features="src/test/resources/features",
		glue={"com.tradingview.stepdefinitions"},
		dryRun=false,
		monochrome=true,
		plugin= {"html:target/htmlreport.html"},
		tags="@Search"
		)

public class TradingViewRunner extends AbstractTestNGCucumberTests {

}
