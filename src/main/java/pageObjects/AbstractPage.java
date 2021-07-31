package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {
    private static WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), 20); // constant?

    public AbstractPage() {
    }

    public boolean isDisplayed(By locator){
        try{
           return DriverFactory
           .getWebDriver()
           .findElement(locator)
           .isDisplayed();
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }
    }

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
