package com.mycompany.automation.tests;

import com.mycompany.automation.base.BaseTest;
import com.mycompany.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        driver.get(ConfigReader.getProperty("url"));

        driver.findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String successMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(successMessage.contains("You logged into a secure area!"));
    }
}
