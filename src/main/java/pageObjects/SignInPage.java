package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignInPage extends AbstractPage {
    //button for sighIn from HomePage
    private By signInButton = By.className("popup-reg-sign-in-form__sign_in");


    //  button Continue after login
    private By sighInContinue = By.id("kc-login-next");

    //  button Continue after password
    private By signInButtonOnPasswordWindow = By.id("kc-login");

    // Find Error after Incorrect password
    private By loginFailedErrorMessage = By.xpath("//span[contains(@class,'error-text')]");


    //location for input login
    private By mailInput = By.id("username");

    //location for input password
    private By passwordInput = By.id("password");

    //$x("//button[@disabled and contains(@id,'kc-login-next')]")
    //location for Continue disabled
    private By buttonContinueDisabled = By.xpath("//button[@disabled and contains(@id,'kc-login-next')]");

    //input email
    public SignInPage enterEmail(String email) {
        getElement(mailInput).clear();
        getElement(mailInput).sendKeys(email);
        return this;
    }

    //input password
    public SignInPage enterPassword(String password) {
        getElement(passwordInput).sendKeys(password);
        return new SignInPage();
    }

    //True, if Error Message after incorrect password
    public boolean isLoginFailedErrorMessageDisplayed() {
        return getElement(loginFailedErrorMessage).isDisplayed();
    }



    //click after password
    public SignInPage clickSignInButtonOnPassword() {
        getElement(signInButtonOnPasswordWindow).click();
        return this;
    }

    //click after login
    public SignInPage clickSignInContinue() {
        getElement(sighInContinue).click();
        return this;
    }

    //bottom after Continue is Visible
    public boolean clickVisibleInContinue() {
        return getElement(sighInContinue).isDisplayed();
    }

    //True, if Continue Visible
    public void verifyContinueDisplayed() {
        Assert.assertTrue(clickVisibleInContinue(),
                "We can click");
    }

    //True, if Error Message after incorrect password
    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(isLoginFailedErrorMessageDisplayed(),
                "We can't find user with such");
    }

    //True, if Continue disabled
    public void verifyAssertClickContinueDisabled() {
        Assert.assertTrue(clickSignInContinueDisable(), "We can't click.It's good!");
          }


    //True, if Continue disabled
    public boolean clickSignInContinueDisable() {
        try {
            boolean test = getElementWithoutVisibility(buttonContinueDisabled).isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
