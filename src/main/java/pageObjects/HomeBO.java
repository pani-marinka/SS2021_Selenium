package pageObjects;

import org.testng.Assert;

public class HomeBO {
    private HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public HomeBO proceedToHomePage() {
        homePage.proceedToHomePage();
        return this;
    }

    public SignInBO clickSignInButton() {
        homePage.clickSignInButton();
        return new SignInBO();
    }

    public void verifyUserIsLoggedIn() {
        Assert.assertTrue(homePage.isUserNameDisplayed(),"User is not logged in");
    }

    public void verifyRightUserNameIsDisplayed(String expectedUserName) {
     //   Assert.assertEquals(homePage.getLoggedInUserName(), expectedUserName);
        Assert.assertTrue(homePage.getLoggedInUserName(), expectedUserName);
    }

}
