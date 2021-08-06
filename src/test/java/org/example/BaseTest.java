package org.example;

import org.testng.annotations.*;
import java.lang.reflect.Method;
import static driver.DriverFactory.initDriver;
import static driver.DriverFactory.quitDriver;

//public abstract class BaseTest extends DriverFactory { //DONE!


public abstract class BaseTest {
    private Test test;


    @Parameters({"browserName"})
   @BeforeMethod(alwaysRun = true)
  //  @BeforeClass(alwaysRun = true)
    public void beforeMethod(@Optional(value = "webdriver.chrome.driver") final String browserName, Method method) {  //only constants NOT DriverConfigs.CHROME.getValueName()

        initDriver(browserName);
    }

       @AfterMethod(alwaysRun = true) public void afterMethod(Method method) {
   // @AfterClass(alwaysRun = true)
   // public void afterMethod() {
        quitDriver();
    }
}
