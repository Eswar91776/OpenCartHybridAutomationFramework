package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.TestBase;
import utilities.DataProviderUtility;
import utilities.ScreenshotUtility;

public class TC_Register extends TestBase {

    @Test(
        dataProvider = "registrationData",
        dataProviderClass = DataProviderUtility.class,
        groups = {"sanity", "regression"}
    )
    public void testRegister(
            String firstName,
            String lastName,
            String email,
            String password) {

        System.out.println("========== Registration Test Started ==========");

        HomePage homePage =
                new HomePage(getDriver());

        homePage.clickmyAccount();

        RegisterPage registerPage =
                homePage.clickmyRegister();

        registerPage.enterFirstName(firstName);

        registerPage.enterLastName(lastName);

        registerPage.enterEmail(email);

        registerPage.enterPassword(password);

        registerPage.clickSubscribe();

        registerPage.clickPrivacyPolicy();

        registerPage.clickContinue();

        Assert.assertTrue(
                registerPage.isRegisterAccountDisplayed());

        Assert.assertTrue(
                registerPage.isAccountCreatedDisplayed());

        try {

            ScreenshotUtility.captureScreenshot(
                    getDriver(),
                    "registerTest");

        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println("========== Registration Test Completed ==========");
    }
}