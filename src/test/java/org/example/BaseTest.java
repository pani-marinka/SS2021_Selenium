package org.example;

import driver.DriverFactory;
import enums.DriverConfigs;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest extends DriverFactory {
    private Test test;

    @Parameters({"browserName"})
    @BeforeMethod
    public void beforeMethod(@Optional(value = "webdriver.chrome.driver") final String browserName, Method method) {  //only constants NOT DriverConfigs.CHROMENAME.getValue()
        initDriver(browserName);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(final Method method) {
        quitDriver();
    }
}
