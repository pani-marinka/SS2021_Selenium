package driver;

import enums.DriverConfigs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class DriverFactory {

    private static WebDriver webDriver;

    /*
    initilazier web driver
     */
    protected void initDriver(final String browesrName) {
        if (DriverConfigs.CHROMENAME.getValue().equalsIgnoreCase(browesrName)) {
            System.setProperty(DriverConfigs.CHROMENAME.getValue(), DriverConfigs.CHROMELOCATION.getValue());
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            //задержка на выполнение теста = 10 сек.
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //constnts

        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    protected void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
