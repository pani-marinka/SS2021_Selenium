package pageObjects;

import enums.BusinessConfigs;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

public class HomePage extends AbstractPage {

    //DONE!  зробити логгер логувати значеня наприклад мейлу
    private static final Logger LOG = Logger.getLogger(SignInPage.class.getName());
    // defining the locator of the login button
    private By signInButton = By.className("header-auth__signin");
    // определение места отоброжения логина после входа в аккаунт
    // determining where the login is displayed after logging into the account
    private By topRightCornerUserNameElement = By.className("user-info__name");


    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        return new SignInPage();
    }

    //  url for HomePage - start
    public HomePage proceedToHomePage() {
        LOG.info(String.format("expected url: %s", BusinessConfigs.BASEURL.getValue()));
        proceedToPage(BusinessConfigs.BASEURL.getValue());
        return this;
    }

    // check: login is displayed?
    public boolean getLoggedInUserName() {
        return getElement(topRightCornerUserNameElement).isDisplayed();
    }


    //Correct email
    public void verifyRightUserNameIsDisplayed(String expectedUserName) {
        LOG.info(String.format("Assert expected user: %s", expectedUserName));
           Assert.assertTrue(getLoggedInUserName(), expectedUserName);
    }


}
//