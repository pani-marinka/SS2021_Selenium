package pageObjects;

import enums.BusinessConfigs;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage {

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

//    public boolean isUserNameDisplayed() {
//        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
//        return isDisplayed;
//    }

    //  url for HomePage - start
    public HomePage proceedToHomePage() {
        proceedToPage(BusinessConfigs.BASEURL.getValue());
        return this;
    }

  // check: login is displayed?
  public boolean getLoggedInUserName() {
      //  return getElement(topRightCornerUserNameElement).getText();  // for example for me!
        return getElement(topRightCornerUserNameElement).isDisplayed();
    }


}
