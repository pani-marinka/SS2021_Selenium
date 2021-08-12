package pageObjects;

import driver.DriverFactory;
import enums.DriverConfigs;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {
    // Work  page with setting WebInterface
    /*
    implementation of the initial setup for interaction with page elements
     */
    private final WebDriverWait wait = new WebDriverWait(
            DriverFactory.getWebDriver(),
            Long.parseLong(DriverConfigs.DRIVERDELAYEXECUTION.getValueName()));

    public AbstractPage() {
    }

    public boolean isDisplayed(By locator){  // перероби для використання
        try{
           return DriverFactory
           .getWebDriver()
           .findElement(locator)
           .isDisplayed();
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }
    }


    // url for our site
    void proceedToPage(final String url) {
        DriverFactory.getWebDriver().get(url);
    }

    WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
        return webElement;
    }


    List<WebElement> getElements (By locator) {
        return DriverFactory.getWebDriver().findElements(locator);
    }



}
//