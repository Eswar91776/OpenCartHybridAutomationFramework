package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBase;
import utilities.DataProviderUtility;

public class TC_Login extends TestBase{

	private static final Logger logger = LogManager.getLogger(TC_Login.class.getName());
	
	@Test(dataProvider = "loginData",
			dataProviderClass = DataProviderUtility.class,
			groups = {"sanity","regression"}
			)
	public void testLogin(String email, String password) {

		logger.info("*********** Login test started *************");
		
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);

		HomePage homePage = new HomePage(getDriver());
		homePage.clickmyAccount();
		LoginPage loginPage = homePage.clickLogin();

		loginPage.enterEmail(email);
		loginPage.enterPassword(password);

		MyAccountPage myAccountPage = loginPage.clickLogin();

		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("Page Title: " + getDriver().getTitle());

		Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
		
		 logger.info("********** Login successful **************");
	}

}
