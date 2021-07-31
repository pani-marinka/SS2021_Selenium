package pageObjects;

import org.testng.Assert;

public class SignInBO {
    private SignInPage signInPage;

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
