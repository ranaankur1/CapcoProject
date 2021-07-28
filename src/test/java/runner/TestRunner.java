package runner;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.AppiumServer;
import utility.CommonUtilss;



@CucumberOptions(features = "src/test/java/feature", 
                 glue = { "stepDefinition" }, // path of step definition
		         plugin = { "com.cucumber.listener.ExtentCucumberFormatter:Automation_Report/Report.html" }, format = { "pretty",
				            "html:test-output", "json:json_output/cucumber.json",
				            "junit:junit_xml/junit.xml" }, 
		         monochrome = true, 
		         dryRun = false, // check all the steps have the
																					// definitions and will not execute
		strict = true, // check if any step is not defined in step definition file
		tags = { "@IOassignment" })


public class TestRunner extends AbstractTestNGCucumberTests {
	//public static AppiumDriver<MobileElement> driver;
	
	@Before
	public void setUp() throws IOException {
		AppiumServer.start();
	}

	@After
	public void tearDown() {
		AppiumServer.stop();
	}

}