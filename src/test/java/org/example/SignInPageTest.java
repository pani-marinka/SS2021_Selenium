package org.example;

import dataProviderForTests.DataProviderClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;


public class SignInPageTest extends BaseTest {


    private HomePage homePage;
    private SignInPage signInPage;


    @BeforeMethod
    public void getСreateObj() {
        homePage = new HomePage();
        signInPage = new SignInPage();


    }


    @Test(description = "verify  user is successfully appropriate credentials",
            dataProvider = "loginPasswordCorrect", dataProviderClass = DataProviderClass.class)
    public void verifyUserisSuccessfullyLoggedIn(String email, String passwordCorrect) {
        homePage

                .proceedToHomePage()
                .clickSignInButton()
                .SignIn(email, passwordCorrect)// !DONE One method active Email,password
                .verifyRightUserNameIsDisplayed("testepammail");
    }

    @Test(description = "verify Error Message Appears when user loggingin with inappropriate credentials",
            dataProvider = "loginPasswordIncorrect", dataProviderClass = DataProviderClass.class)
    public void verifyErrorMessageAppearsForIncorrectUser(String email, String passwordIncorrect) {

        homePage
                .proceedToHomePage()
                .clickSignInButton()
                .SignIn(email, passwordIncorrect);
        signInPage
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "verify boundary login with 10 symbols after @Dot is successfully appropriate credentials",
            dataProvider = "loginBoundaryCorrectData", dataProviderClass = DataProviderClass.class)
    public void verifyCorrectEmailBoundary10(String email) {
        homePage
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .verifyContinueDisplayed();
    }


    @Test(description = "entered mail matches without criteria and disable bottom continue",
            dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
    public void notVerifyIncorrectMailUser(String data) {

        homePage
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(data)
                .verifyAssertClickContinueDisabled();
    }

    //for test Example HardTest
    @Test(description = "entered mail and disable bottom continue")
    public void notVerifyIncorrectMailUserHardAssert() {
        homePage
                .proceedToHomePage()
                .clickSignInButton()
                .verifyHardAssertContinueDisabled();
    }

    //exampleSoftAssert
    @Test(description = "entered mail and disable bottom continue")
    public void notVerifyIncorrectMailUserSoftAssert() {
        homePage
                .proceedToHomePage()
                .clickSignInButton()
                .verifySoftAssertContinueDisabled();
    }

}
