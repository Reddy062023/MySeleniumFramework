package com.mycompany.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQAPage {

    private WebDriver driver;

    // Constructor to accept WebDriver
    public DemoQAPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for logo
    private By logo = By.cssSelector("img[alt='Demoqa']"); // adjust selector as needed

    // Open home page
    public void openHomePage(String url) {
        driver.get(url);
    }

    // Verify if logo is displayed
    public boolean isLogoDisplayed() {
        WebElement logoElement = driver.findElement(logo);
        return logoElement.isDisplayed();
    }
}
