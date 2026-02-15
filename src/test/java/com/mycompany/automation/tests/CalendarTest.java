package com.mycompany.automation.tests;

import com.mycompany.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CalendarTest extends BaseTest {

    @Test
    public void selectDateFromCalendar() {

        // Navigate to the jQuery UI date picker demo
        driver.get("https://jqueryui.com/datepicker/");

        // Update WebDriverWait initialization to remove deprecated constructor
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Switch to the frame (since the date picker is inside an iframe)
        driver.switchTo().frame(0);

        // Locator for the date input field in jQuery UI Date Picker
        By dateInputLocator = By.id("datepicker");

        // Wait for the input field to be clickable
        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(dateInputLocator));

        // Scroll to the element (this may not be strictly needed but ensures smooth interaction)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", dateInput);

        // Click the input field to open the date picker
        dateInput.click();

        // Wait for the calendar to load and click a specific date (e.g., 15th of the month)
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='15']")));  // Selecting the 15th
        date.click();

        // Optionally, verify that the date was correctly entered in the input field
        String selectedDate = dateInput.getAttribute("value");
        System.out.println("Selected Date: " + selectedDate);
    }
}
