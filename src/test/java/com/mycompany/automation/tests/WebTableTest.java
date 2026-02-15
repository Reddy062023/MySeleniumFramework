package com.mycompany.automation.tests;

import com.mycompany.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends BaseTest {

    @Test
    public void verifyProductInTable() {
        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));

        String expectedProduct = "Learn Selenium";
        boolean found = rows.stream().anyMatch(row -> row.getText().contains(expectedProduct));

        Assert.assertTrue(found, "Product '" + expectedProduct + "' was not found in the table");
    }
}
