package com.myjavacode.misc;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFileProcessing {
    public static void main(String[] args) throws IOException {

//        Path fileToMovePath = Paths.get("/home/um-143-user/Downloads/flowone_20221226.zip");
//        Path targetPath = Paths.get("/home/um-143-user/Downloads/flowoneeee.zip");
//            Files.move(fileToMovePath, targetPath);
//        readZipFile("/home/um-143-user/Pictures/flowone.zip");
////        readZipFile();
        System.out.println((1 << 2) + ":" + (2 << 2));

    }


    public static void rename(String newFilePath, String oldFilePath) throws IOException {
        Path fileToMovePath = Paths.get(oldFilePath);
        Path targetPath = Paths.get(newFilePath);
        Files.move(fileToMovePath, targetPath);
    }

    public static void readZipFile(String newFileNamePath) throws IOException {
        try (ZipFile zipFile = new ZipFile(newFileNamePath)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry =  entries.nextElement();
                if (zipEntry.getName().contains("PUSH")) {
                    rename(zipEntry.getName().replace(".csv", ""), zipEntry.getName());
                } else if (zipEntry.getName().contains("SMS")) {
                } else if (zipEntry.getName().contains("CONNECTOR")) {
                }
            }
        }
    }

}
