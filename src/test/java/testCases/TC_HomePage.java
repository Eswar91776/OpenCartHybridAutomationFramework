package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.TestBase;

public class TC_HomePage extends TestBase {

    @Test
    public void testHomePage() {

        System.out.println("========== HOME PAGE TEST ==========");

        HomePage homePage = new HomePage(getDriver());

        homePage.clickmyAccount();

        System.out.println("My Account clicked successfully.");

        System.out.println("====================================");
    }
}