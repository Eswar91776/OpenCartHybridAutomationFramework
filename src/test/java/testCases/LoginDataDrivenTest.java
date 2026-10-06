package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBase;
import utilities.DataProviderUtility;

public class LoginDataDrivenTest extends TestBase {

    @Test(
        dataProvider = "loginData",
        dataProviderClass = DataProviderUtility.class,
        groups = {"sanity", "regression"}
    )
    public void testLoginDataDriven(String email, String password) {

        System.out.println("========== DATA DRIVEN LOGIN STARTED ==========");

        System.out.println("Email: " + email);

        HomePage homePage = new HomePage(getDriver());

        homePage.clickmyAccount();

        LoginPage loginPage = homePage.clickLogin();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        MyAccountPage myAccountPage = loginPage.clickLogin();

        Assert.assertTrue(
            myAccountPage.isMyAccountPageDisplayed(),
            "My Account page was not displayed"
        );

        System.out.println("Login successful.");

        myAccountPage.clickLogout();

        System.out.println("Logout successful.");

        System.out.println("========== DATA DRIVEN LOGIN COMPLETED ==========");
    }
}