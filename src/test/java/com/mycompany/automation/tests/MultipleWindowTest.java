package com.mycompany.automation.tests;

import com.mycompany.automation.base.BaseTest;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class MultipleWindowTest extends BaseTest {

    @Test
    public void testMultipleWindows() {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Switch to iframe
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iframeResult")));
        driver.switchTo().frame(iframe);

        // Click "Try it" button
        WebElement tryItButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Try it']")));
        tryItButton.click();

        // Switch back to default content for window handling
        driver.switchTo().defaultContent();

        // Get all window handles
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        String newWindow = null;

        for (String w : windows) {
            if (!w.equals(parentWindow)) {
                newWindow = w;
                driver.switchTo().window(newWindow);
                System.out.println("New window title: " + driver.getTitle());
                System.out.println("New window URL: " + driver.getCurrentUrl());
                break;
            }
        }

        // Assert a new window opened
        Assert.assertNotNull(newWindow, "New window did not open");

        // Optional: check URL instead of title
        Assert.assertTrue(driver.getCurrentUrl().contains("w3schools"), "New window URL is unexpected");

        // Close new window
        driver.close();

        // Switch back to parent
        driver.switchTo().window(parentWindow);
        System.out.println("Parent window title: " + driver.getTitle());

        // Close parent window at the end
        driver.quit();
    }
}
