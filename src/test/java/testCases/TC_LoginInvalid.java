package testCases;




import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.TestBase;
import utilities.DataProviderUtility;

public class TC_LoginInvalid extends TestBase{
	
    @Test(dataProvider = "loginInvalidData",
    		dataProviderClass = DataProviderUtility.class,
    		groups = {"regression"}
    		)
    public void testLoginInvalid(String email,String password,String expectedMessage) {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickmyAccount();
        LoginPage loginPage = homePage.clickLogin();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        loginPage.clickLogin();

//        Assert.assertTrue(loginPage.isLoginWarningDisplayed());
        Assert.assertEquals(loginPage.getLoginWarningMessage(),expectedMessage);
    }

}
