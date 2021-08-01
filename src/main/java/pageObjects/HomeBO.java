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

    public HomeBO clickSignInButton() {
        homePage.clickSignInButton();
        return this;
    }


    public void verifyRightUserNameIsDisplayed(String expectedUserName) {
     //   Assert.assertEquals(homePage.getLoggedInUserName(), expectedUserName);
        Assert.assertTrue(homePage.getLoggedInUserName(), expectedUserName);
    }

}
