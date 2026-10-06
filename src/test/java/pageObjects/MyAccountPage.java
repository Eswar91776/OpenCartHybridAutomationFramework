package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space()='My Account']")
    WebElement myAccountHeading;

    @FindBy(xpath = "//*[@id='top']/div/div/div[2]/ul/li[2]/div/span/span")
    WebElement myAccountMenu;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutLink;

    WaitUtility waitUtility;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        waitUtility = new WaitUtility(driver);
    }

    public boolean isMyAccountPageDisplayed() {

        waitUtility.waitForElementToBeVisible(myAccountHeading);

        return myAccountHeading.isDisplayed();
    }

    public void clickLogout() {

        // Open My Account dropdown
        waitUtility.clickWhenReady(myAccountMenu);

        // Click Logout
        waitUtility.clickWhenReady(logoutLink);
    }
}