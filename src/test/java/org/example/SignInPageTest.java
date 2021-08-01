package org.example;

import confProperty.ConfProperties;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomeBO;
import pageObjects.SignInPage;

public class SignInPageTest extends BaseTest {

    @Test(description = "verify  user is successfully appropriate credentials")
    public void verifyUserisSuccessfullyLoggedIn() {
        SignInPage signInPage = new SignInPage();
        HomeBO homeBO = new HomeBO();

        homeBO
                .proceedToHomePage()
                .clickSignInButton();
        signInPage
                .enterEmail(ConfProperties.getProperty("login"))
                .clickSignInContinue()
                .enterPassword(ConfProperties.getProperty("passwordCorrect")) //Testepam123
                .clickSignInButtonOnPassword();
        homeBO
                .verifyRightUserNameIsDisplayed("testepammail");//Марина testepammail
    }

    @Test(description = "verify Error Message Appears when user logging in with inappropriate credentials")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        SignInPage signInPage = new SignInPage();
        HomeBO homeBO = new HomeBO();

        homeBO
                .proceedToHomePage()
                .clickSignInButton();
        signInPage
                .enterEmail(ConfProperties.getProperty("login"))
                .clickSignInContinue()
                .enterPassword(ConfProperties.getProperty("passwordInCorrect"))
                .clickSignInButtonOnPassword()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "verify boundary login with 10 symbols after @Dot is successfully appropriate credentials")
    public void verifyCorrectEmailBoundary10() {
        SignInPage signInPage = new SignInPage();
        HomeBO homeBO = new HomeBO();

        homeBO
                .proceedToHomePage()
                .clickSignInButton();
        signInPage
                .enterEmail(ConfProperties.getProperty("loginPositiveBoundaryTest10After@Dot"))
                .verifyContinueDisplayed();
    }


    //for test Example HardTest
    @Test(description = "entered mail matches without criteria and disable bottom continue")
    public void notVerifyIncorrectMailUser() {
        SignInPage signInPage = new SignInPage();
        HomeBO homeBO = new HomeBO();
        homeBO
                .proceedToHomePage()
                .clickSignInButton();
        signInPage
                .enterEmail(ConfProperties.getProperty("loginWithout@"))
                .verifyAssertClickContinueDisabled();
        signInPage
                .enterEmail(ConfProperties.getProperty("loginBegin@"))
                .verifyAssertClickContinueDisabled();
        signInPage
                .enterEmail(ConfProperties.getProperty("loginWithoutDot"))
                .verifyAssertClickContinueDisabled();
        signInPage
                //.enterEmail(ConfProperties.getProperty("login")) // test for HARDSOFT
                 .enterEmail(ConfProperties.getProperty("login11After"))//("testepammail@ukr.netnetnetne")  //
                .verifyAssertClickContinueDisabled();
    }

    //exampleSoftAssert
    @Test(description = "entered mail matches without criteria and disable bottom continue")
    public void notVerifyIncorrectMailUserSoft() {
        SignInPage signInPage = new SignInPage();
        HomeBO homeBO = new HomeBO();
        SoftAssert soft = new SoftAssert();
        homeBO
                .proceedToHomePage()
                .clickSignInButton();

        boolean Test = signInPage
                .enterEmail(ConfProperties.getProperty("loginWithout@"))
                .clickSignInContinueDisable();
        soft.assertTrue(Test,
                "We musn't click loginWithout@!");

        // .verifyAsserClickContinueDisabled();
        soft.assertTrue(signInPage
                        .enterEmail(ConfProperties.getProperty("loginBegin@"))
                        .clickSignInContinueDisable(),
                "We musn't click loginBegin@!");
        soft.assertTrue(signInPage
                        .enterEmail(ConfProperties.getProperty("login11After"))
                        .clickSignInContinueDisable(),
                "We musn't click login11After!");

        soft.assertTrue(signInPage
                        .enterEmail(ConfProperties.getProperty("login"))  // .enterEmail(ConfProperties.getProperty("loginWithoutDot"))
                        .clickSignInContinueDisable(),
                "ITS TEST login for Log!");
        soft.assertTrue(signInPage
                        .enterEmail(ConfProperties.getProperty("loginWithoutDot"))
                        .clickSignInContinueDisable(),
                "We musn't click loginWithoutDot!");
        soft.assertAll();
    }



}
