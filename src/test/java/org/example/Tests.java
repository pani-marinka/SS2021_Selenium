package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserSuccessfullyLoggedIn() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maryna\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#!/Home?lang=en");
        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("username"));
        mailInput.sendKeys("testepammail@ukr.net");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Testepam123");
        WebElement signInButtonOnPasswordWindow = driver.findElement(By.id("kc-login"));
        signInButtonOnPasswordWindow.click();

        WebElement userName = driver.findElement(By.className("user-info__name"));
        Assert.assertTrue(userName.isDisplayed(), "Username is NOT displayed");

        driver.quit();
    }

    @Test(description = "Verify user is NOT successfully logged in with incorrect password")
    public void verifyUserNotLoggedWithInvalidPassword() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maryna\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#!/Home?lang=en");
        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("username"));
        mailInput.sendKeys("testepammail@ukr.net");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("incorrect");
        WebElement signInButtonOnPasswordWindow = driver.findElement(By.id("kc-login"));
        signInButtonOnPasswordWindow.click();

        boolean checkMessage = driver.getPageSource().contains("We can't find user");// We can't find user with such credentials.
        Assert.assertTrue(checkMessage, "NOT found!");

        driver.quit();
    }
}