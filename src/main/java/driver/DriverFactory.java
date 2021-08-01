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
            //delay for test execution = 10 si.
            webDriver.manage().timeouts().implicitlyWait(
                    Long.parseLong(DriverConfigs.DRIVERDELAYEXECUTION.getValue()),
                    TimeUnit.SECONDS);

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
