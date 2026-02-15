package com.mycompany.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LocatorsReader {

    private static Properties locators = new Properties();

    static {
        try (InputStream input = LocatorsReader.class.getClassLoader()
                     .getResourceAsStream("locators.properties")) {

            if (input == null) {
                System.out.println("locators.properties not found!");
            } else {
                locators.load(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load locators.properties");
        }
    }

    /**
     * Get locator value from locators.properties by key
     *
     * @param key locator key
     * @return locator value
     */
    public static String getLocator(String key) {
        return locators.getProperty(key);
    }
}
