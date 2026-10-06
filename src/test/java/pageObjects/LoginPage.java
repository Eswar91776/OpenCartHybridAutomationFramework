package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class LoginPage extends BasePage{
	
	@FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//div[@class='mb-3']//a[normalize-space()='Forgotten Password']")
    WebElement forgottenPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;
    
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement loginWarning;
    
    public void enterEmail(String emailAddress) {
        email.sendKeys(emailAddress);
    }

    public void enterPassword(String passwordText) {
        password.sendKeys(passwordText);
    }
    

    public MyAccountPage clickLogin() {
        loginButton.click();
        return new MyAccountPage(driver);
    }

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	WaitUtility waitUtility;
	
	public boolean isLoginWarningDisplayed() {
		waitUtility.waitForElementToBeVisible(loginWarning);
	    return loginWarning.isDisplayed();
	}
	
	public String getLoginWarningMessage() {

	    waitUtility.waitForElementToBeVisible(loginWarning);
	    return loginWarning.getText();
	}
	
}
