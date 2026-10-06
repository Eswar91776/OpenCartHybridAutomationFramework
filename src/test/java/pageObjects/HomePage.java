package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"top\"]/div/div/div[2]/ul/li[2]/div/span/span")
    WebElement myAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement register;

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
    WebElement login;

    WaitUtility waitUtility;

    public HomePage(WebDriver driver) {
        super(driver);
        waitUtility = new WaitUtility(driver);
    }

    public void clickmyAccount() {
        waitUtility.clickWhenReady(myAccount);
    }

    public RegisterPage clickmyRegister() {

        waitUtility.clickWhenReady(register);

        System.out.println(
                "URL after clicking Register: "
                + driver.getCurrentUrl());

        System.out.println(
                "Title after clicking Register: "
                + driver.getTitle());

        return new RegisterPage(driver);
    }

    public LoginPage clickLogin() {

        waitUtility.clickWhenReady(login);

        return new LoginPage(driver);
    }
}