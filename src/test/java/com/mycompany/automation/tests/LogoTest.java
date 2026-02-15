package com.mycompany.automation.tests;

import com.mycompany.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoTest extends BaseTest {

    @Test
    public void verifyLogoIsDisplayed() {
        // Open the jQuery UI homepage
        driver.get("https://jqueryui.com/");

        // Increase wait time to 20 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Alternative: Try XPath to locate the logo (this assumes the image is within a container with text 'jQuery UI')
        By logoLocatorXPath = By.xpath("//img[contains(@alt, 'jQuery') and contains(@src, 'jqueryui.com')]");

        // Wait until the logo is visible using XPath
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(logoLocatorXPath));

        // Assert the logo is displayed
        Assert.assertTrue(logo.isDisplayed(), "jQuery UI Logo is NOT displayed");
    }
}
