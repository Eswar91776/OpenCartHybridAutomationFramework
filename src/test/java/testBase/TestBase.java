package testBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;
import utilities.DriverFactory;

public class TestBase {

	public static WebDriver getDriver() {
		return DriverFactory.getDriver();
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser", "os"})
	public void openBrowser(String browser, String os) throws IOException {

	    System.out.println("========== openBrowser() EXECUTED ==========");

	    ConfigReader config = new ConfigReader();

	    System.out.println("Browser parameter: " + browser);
	    System.out.println("OS parameter: " + os);

	    String executionEnv = config.getExecutionEnv();
	    String gridUrl = config.getGridUrl();

	    System.out.println("Execution Environment: " + executionEnv);
	    System.out.println("Grid URL: " + gridUrl);

	    DriverFactory.initDriver(browser, executionEnv, gridUrl);

	    System.out.println("Driver after initialization: " + getDriver());

	    getDriver().manage().deleteAllCookies();
	    getDriver().get(config.getUrl());
	    getDriver().manage().window().maximize();

	    System.out.println("Driver after opening browser: " + getDriver());
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}