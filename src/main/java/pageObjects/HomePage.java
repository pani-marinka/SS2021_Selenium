package pageObjects;

import enums.BusinessConfigs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    // @FindBy
    private By signInButton = By.className("header-auth__signin");
            //By.xpath("//p[@class = 'header-auth__signin']//span "); // By.className("header-auth__signin");
            //By.xpath("//p[@class = 'header-auth__signin']//span ");
    //private By sighInButton = By.className("header-auth__signin");
//(By.className("header-auth__signin")
    /**
     * определение локатора кнопки входа в аккаунт
     *
     * @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
     * private WebElement loginBtn;
     * @FindBy private WebElement loginBtn = driver.findElement(By.id("username"));
     */
    private By topRightCornerUserNameElement = By.className("user-info__name");
// WebElement mailInput = driver.findElement(By.id("username"));

    /* определение локатора поля ввода пароля

   @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
   private WebElement passwdField;
*/
    /*
    @FindBy
    private WebElement continueButton = driver.findElement(By.id("kc-login-next"));

    @FindBy
    private WebElement userSuccess = driver.findElement(By.id("user-info__name")); ;
*/

    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        return new SignInPage();
    }

    public boolean isUserNameDisplayed() {
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        return isDisplayed;
    }

    public HomePage proceedToHomePage() {
        proceedToPage(BusinessConfigs.BASEURL.getValue());
        return this;
    }

  //  public String getLoggedInUserName() {
  public boolean getLoggedInUserName() {
      //  return getElement(topRightCornerUserNameElement).getText();
        return getElement(topRightCornerUserNameElement).isDisplayed();
    }


}
