package driver;

import enums.DriverConfigs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverFactory {

    private static WebDriver webDriver;

    /*
    initilazier web driver
     */
    //protected void initDriver(final String browesrName) {
    public static void initDriver(final String browesrName) {

        if (DriverConfigs.CHROME.getValueName().equalsIgnoreCase(browesrName)) {
            System.setProperty(DriverConfigs.CHROME.getValueName(), DriverConfigs.CHROME.getValueLocatin());
            webDriver = new ChromeDriver();

        } else if (DriverConfigs.FIREFOX.getValueName().equalsIgnoreCase(browesrName)) {
            System.setProperty(DriverConfigs.FIREFOX.getValueName(), DriverConfigs.FIREFOX.getValueLocatin());
            webDriver = new FirefoxDriver();
        } else if (DriverConfigs.EDGE.getValueName().equalsIgnoreCase(browesrName)) {
            System.setProperty(DriverConfigs.EDGE.getValueName(), DriverConfigs.EDGE.getValueLocatin());
            webDriver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser not found!");  // DONE! if  драйвер не пыдтримуется обробляти цей ексепшен
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(
                Long.parseLong(DriverConfigs.DRIVERDELAYEXECUTION.getValueName()),
                TimeUnit.SECONDS);


    }

    public static WebDriver getWebDriver() {
     //if (webDriver== null) ?
        return webDriver;
    }

    //protected void quitDriver() {
    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
