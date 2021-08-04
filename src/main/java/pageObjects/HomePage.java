package pageObjects;

import enums.BusinessConfigs;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

public class HomePage extends AbstractPage {

    //DONE!  зробити логгер логувати значеня наприклад мейлу
    private static final Logger LOG = Logger.getLogger(SignInPage.class.getName());


    // определение локатора кнопки входа в аккаунт
    // defining the locator of the login button
    private By signInButton = By.className("header-auth__signin");

    // определение места отоброжения логина после входа в аккаунт
    // determining where the login is displayed after logging into the account
    private By topRightCornerUserNameElement = By.className("user-info__name");


    //page TrainingList
    //private By trainingListButton = By.className("topNavItem training click hover");

    //private By buttonContinueDisabled = By.xpath("//button[@disabled and contains(@id,'kc-login-next')]");

    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        return new SignInPage();
    }

    /*
    <a href="/#!/TrainingList" class="topNavItem training click hover" route-link-active="">Training list</a>
     */

    //  url for HomePage - start
    public HomePage proceedToHomePage() {
        LOG.info(String.format("expected url: %s", BusinessConfigs.BASEURL.getValue()));
        proceedToPage(BusinessConfigs.BASEURL.getValue());
        return this;
    }

    // check: login is displayed?
    public boolean getLoggedInUserName() {
        //  return getElement(topRightCornerUserNameElement).getText();  // for example for me!
        return getElement(topRightCornerUserNameElement).isDisplayed();
    }


    public SignInPage getUrlHomeClickSignIn() { //  for download URL HomePage and click SignIn
        LOG.info(String.format("Download url"));
        proceedToHomePage()
                .clickSignInButton();
        LOG.info(String.format("Get field for loggin"));
        return new SignInPage(); //this?
    }


    //Correct email
    public void verifyRightUserNameIsDisplayed(String expectedUserName) {
        LOG.info(String.format("Assert expected user: %s", expectedUserName));
        //   Assert.assertEquals(homePage.getLoggedInUserName(), expectedUserName);
        Assert.assertTrue(getLoggedInUserName(), expectedUserName);
    }


}
