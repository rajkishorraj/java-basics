package com.myjavacode.misc;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class JsonProcessing {

    public static void main(String[] args) {
        try {
            // Read JSON string from file
            String inputFilePath = "/home/um-143-user/Documents/branch_webhook_install_schem.json";
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            reader.close();

            // Remove slashes and extra spaces
            String cleanedJson = jsonString.toString()
                    .replaceAll("\\n", "")
                    .replaceAll("\\s+", "")
                    .replaceAll("\\\\", "");

            // Save cleaned JSON to file
            String outputFilePath = "/home/um-143-user/Documents/branch_webhook_install_schema_o.json";
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write(cleanedJson);
            writer.close();

            System.out.println("Cleaned JSON saved to file: " + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

