package com.mycompany.automation.pages;

import com.mycompany.automation.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver = DriverFactory.getDriver();

    private By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    public void addItemToCart() {
        driver.findElement(addToCart).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public boolean isInventoryPage() {
        return driver.getCurrentUrl().contains("inventory");
    }
}
