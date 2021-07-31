package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignInPage extends AbstractPage {
    //private By sighInButton = By.xpath("//p[@class = 'header-auth__signin']//span ");
    private By signInButton = By.className("popup-reg-sign-in-form__sign_in");


    private By sighInContinue = By.id("kc-login-next");
    private By signInButtonOnPasswordWindow = By.id("kc-login");
    /*
     private WebElement continueButton = driver.findElement(By.id("kc-login-next"));
     */
    private By loginFailedErrorMessage = By.xpath("//span[contains(@class,'error-text')]");
  //  private By loginFailedErrorMessage = By.xpath("//div[text() = 'We can't find user with such']");
    //By.xpath("//span[contains(@class,'error-text')]");
    //.xpath("//div[text() = 'We can't find user with such']");
//boolean checkMessage = driver.getPageSource().contains("We can't find user");// We can't find user with such credentials.
//        Assert.assertTrue(checkMessage, "NOT found!");

    private By mailInput = By.id("username");
    private By passwordInput = By.id("password");


    /*
     WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("username"));
        mailInput.sendKeys("testepammail@ukr.net");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passwordInput = driver.findElement(By.id("password"));
     */

    AbstractPage abstractPage = new AbstractPage();

    public SignInPage enterEmail(String email) {

//        WebElement mailInput = DriverFactory.getWebDriver().findElement(By.id("username"));
//        mailInput.sendKeys(email);

        getElement(mailInput).sendKeys(email);
        return this;
    }

    public SignInPage enterPassword(String password) {
        getElement(passwordInput).sendKeys(password);
        return this;
    }

    public boolean isLoginFailedErrorMessageDisplayed() {

        return getElement(loginFailedErrorMessage).isDisplayed();
    }

//    public boolean isLoginFailedErrorMessageDisplayed() {
//        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
//        return isDisplayed;
//    }

    /*
    public boolean getLoggedInUserName() {
      //  return getElement(topRightCornerUserNameElement).getText();
        return getElement(topRightCornerUserNameElement).isDisplayed();
     */


    public HomePage clickSignInButton() {
        getElement(signInButton).click();
        return new HomePage();
    }

    public SignInPage clickSignInButtonOnPassword() {
        getElement(signInButtonOnPasswordWindow).click();
        return this;
    }

    public SignInPage clickSignInContinue() { // its mine
        getElement(sighInContinue).click();
        return this;
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(isLoginFailedErrorMessageDisplayed(),
                "We can't find user with such");
    }


}
