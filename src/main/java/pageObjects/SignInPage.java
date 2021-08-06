package pageObjects;

import enums.LoginConfig;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;

import static org.testng.Assert.assertTrue;

public class SignInPage extends AbstractPage {

    //DONE!  зробити логгер логувати значеня наприклад мейлу
    private static final Logger LOG = Logger.getLogger(SignInPage.class.getName());
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
    //location for Continue disabled
    private By buttonContinueDisabled = By.xpath("//button[@disabled and contains(@id,'kc-login-next')]");

    //input email
    public SignInPage enterEmail(String email) {
        getElement(mailInput).clear();
        LOG.info("Mail will be entered.");
        getElement(mailInput).sendKeys(email);
        LOG.info(String.format("Mail %s was entered.", email));
        return this;
    }

    //input password
    public SignInPage enterPassword(String password) {
        LOG.info(String.format("expected password: %s", password));
        getElement(passwordInput).sendKeys(password);
        LOG.info(String.format("Password entered!"));
        return new SignInPage();  //this?
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
        LOG.info(String.format("Continue displayed"));
        assertTrue(clickVisibleInContinue(),
                "We can click");
    }

    //True, if Error Message after incorrect password
    public void verifyFailedLoginErrorMessageDisplayed() {
        LOG.info(String.format("Login is not correct for test"));
        assertTrue(isLoginFailedErrorMessageDisplayed(),
                "We can't find user with such credential");
        LOG.info(String.format("Web didnt pass incorrect login!"));
    }

    //True, if Continue disabled
    public void verifyAssertClickContinueDisabled() {
        LOG.info(String.format("Continue is expected displayed"));
        assertTrue(isDisplayed(buttonContinueDisabled), "We musn't click.It's good!");
        LOG.info(String.format("Continue is not displayed"));
    }


    public HomePage SignIn(String email, String password) { //  for input email/password

        LOG.info("Mail was entered.");
        enterEmail(email)
                .clickSignInContinue()
                .enterPassword(password)
                .clickSignInButtonOnPassword();
        return new HomePage(); //this?
    }


    public void verifySoftAssertContinueDisabled() {
        SoftAssert soft = new SoftAssert(); //DONE! внутри верифая делать софт ассерт
        for (Enum enam : LoginConfig.values()) {
            String email = enam.toString();
            LOG.info(String.format("Mail %s expected", email));
            enterEmail(email);
            soft.assertTrue(isDisplayed(buttonContinueDisabled), "We musn't click!");
            LOG.info("Button is not active");
        }
        soft.assertAll();
    }

    public void verifyHardAssertContinueDisabled() {
        for (Enum enam : LoginConfig.values()) {
            String email = enam.toString();
            LOG.info(String.format("Mail %s expected", email));
            enterEmail(email);
            assertTrue(isDisplayed(buttonContinueDisabled), "We musn't click!");
            LOG.info("Button is not active");
        }
    }

}
