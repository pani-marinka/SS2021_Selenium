package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

// !!!!!!!!!!!not used :(  It's in lecture

public class SignInBO extends AbstractPage{
    private SignInPage signInPage;

    //location for input login
    private By mailInput = By.id("username");

    //location for input password
    private By passwordInput = By.id("password");

    public SignInBO() {
        signInPage = new SignInPage();
    }

    public HomeBO login(String mail, String password) {
        signInPage.enterEmail(mail)
                    .clickSignInContinue();

                  signInPage.enterPassword(password)
               .clickSignInButtonOnPassword();
        return new HomeBO();
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(signInPage.isLoginFailedErrorMessageDisplayed(),
                "We can't find user with such");
    }


}
