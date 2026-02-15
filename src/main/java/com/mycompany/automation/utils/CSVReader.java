package com.mycompany.automation.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    /**
     * Reads CSV file from testdata folder and returns list of String arrays
     *
     * @param fileName name of the CSV file (e.g., "users.csv")
     * @return List of String arrays (each array is a row)
     */
    public static List<String[]> readCSV(String fileName) {
        List<String[]> records = new ArrayList<>();

        try (InputStream input = CSVReader.class.getClassLoader()
                     .getResourceAsStream("testdata/" + fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            String line;
            boolean firstLine = true; // skip header
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                records.add(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read CSV file: " + fileName);
        }

        return records;
    }
}
