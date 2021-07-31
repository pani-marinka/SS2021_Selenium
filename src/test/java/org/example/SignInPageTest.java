package org.example;

import org.testng.annotations.Test;
import pageObjects.HomeBO;
import pageObjects.SignInBO;
import pageObjects.SignInPage;

public class SignInPageTest extends BaseTest {

    @Test(description = "verify Error Message Appears when user logging in with inappropriate credentials")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        SignInPage signInPage = new SignInPage();
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton();
       signInPage
                .enterEmail("testepammail@ukr.net")
                .clickSignInContinue();

        new  SignInPage()
                .enterPassword("incorrect")
               .clickSignInButtonOnPassword()
               .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "verify  user is successfully appropriate credentials")
    public void verifyUserisSuccessfullyLoggedIn() {
        HomeBO homeBO = new HomeBO();
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("testepammail@ukr.net")
                .clickSignInContinue()
                .enterPassword("Testepam123")
                .clickSignInButtonOnPassword();
             homeBO
                .verifyRightUserNameIsDisplayed("testepammail");//Марина testepammail
    }
}
