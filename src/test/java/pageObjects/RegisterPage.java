package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class RegisterPage extends BasePage {

    // Registration page heading
    @FindBy(xpath = "//*[@id='content']/h1")
    WebElement registerAccountHeading;

    // First Name
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    // Last Name
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    // Email
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    // Password
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    // Newsletter
    @FindBy(xpath = "//input[@id='input-newsletter']")
    WebElement subscribe;

    // Privacy Policy
    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyPolicy;

    // Continue button
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    // Account created heading
    // NOTE: We will correct this locator later
    // after confirming the actual success page.
    @FindBy(xpath = "//*[@id='content']/h1")
    WebElement accountCreatedMessage;

    WaitUtility waitUtility;

    public RegisterPage(WebDriver driver) {

        super(driver);

        waitUtility = new WaitUtility(driver);

        // Make sure registration page has loaded
        waitUtility.waitForVisibility(registerAccountHeading);

        System.out.println("Registration page loaded successfully.");
    }

    public void enterFirstName(String fname) {

        waitUtility.typeWhenVisible(firstName, fname);
    }

    public void enterLastName(String lname) {

        waitUtility.typeWhenVisible(lastName, lname);
    }

    public void enterEmail(String mail) {

        waitUtility.typeWhenVisible(email, mail);
    }

    public void enterPassword(String pwd) {

        waitUtility.typeWhenVisible(password, pwd);
    }

    public void clickSubscribe() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                subscribe);
    }

    public void clickPrivacyPolicy() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                privacyPolicy);
    }

    public void clickContinue() {

        waitUtility.waitForElementToBeClickable(
                continueButton);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                continueButton);
    }

    public boolean isRegisterAccountDisplayed() {

        return registerAccountHeading.isDisplayed();
    }

    public boolean isAccountCreatedDisplayed() {

        return accountCreatedMessage.isDisplayed();
    }
}