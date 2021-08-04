package org.example;

import dataProviderForTests.DataProviderClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.SignInPage;


public class SignInPageTest extends BaseTest {


    private HomePage homePage;
    private SignInPage signInPage;

    @BeforeClass
    public void getСreateObj() {
        homePage = new HomePage();// DONE!  один объект
        signInPage = new SignInPage();
    }

    @Test(description = "verify  user is successfully appropriate credentials",
            dataProvider = "loginPasswordCorrect", dataProviderClass = DataProviderClass.class)
    public void verifyUserisSuccessfullyLoggedIn(String email, String passwordCorrect) {
        homePage
                .getUrlHomeClickSignIn()
                .enterEmailPasswordSignIn(email, passwordCorrect)// !DONE One method active Email,password
                .verifyRightUserNameIsDisplayed("testepammail");
    }

    @Test(description = "verify Error Message Appears when user loggingin with inappropriate credentials",
            dataProvider = "loginPasswordIncorrect", dataProviderClass = DataProviderClass.class)
    public void verifyErrorMessageAppearsForIncorrectUser(String email, String passwordIncorrect) {

        homePage
                .getUrlHomeClickSignIn()
                .enterEmailPasswordSignIn(email, passwordIncorrect);
        signInPage
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "verify boundary login with 10 symbols after @Dot is successfully appropriate credentials",
            dataProvider = "loginBoundaryCorrectData", dataProviderClass = DataProviderClass.class)
    public void verifyCorrectEmailBoundary10(String email) {
        homePage
                .getUrlHomeClickSignIn()
                .enterEmail(email)
                .verifyContinueDisplayed();
    }


    //for test Example HardTest
    @Test(description = "entered mail matches without criteria and disable bottom continue",
            dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
    public void notVerifyIncorrectMailUser(String data) {

        homePage
                .getUrlHomeClickSignIn()
                .enterEmail(data)
                .verifyAssertClickContinueDisabled();
    }

    //exampleSoftAssert
    @Test(description = "entered mail matches without criteria and disable bottom continue",
            dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
    public void notVerifyIncorrectMailUserSoft(String email) {
        SoftAssert soft = new SoftAssert();
        homePage
                .getUrlHomeClickSignIn();
        soft.assertTrue(signInPage.enterEmail(email).checkContinueDisable(),
                "We musn't click!");
        soft.assertAll();
    }
}
