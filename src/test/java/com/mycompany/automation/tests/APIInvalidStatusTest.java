package com.mycompany.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;

public class APIInvalidStatusTest {

    @Test
    public void validateInvalidStatusCode() throws Exception {
        // Invalid URL to simulate a 404 error (non-existent endpoint)
        URL url = new URL("https://jsonplaceholder.typicode.com/invalid-endpoint");  
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();

        // Expecting a 404 status code for the invalid endpoint
        Assert.assertEquals(status, 404, "API did not return HTTP 404 for invalid endpoint");
    }
}
