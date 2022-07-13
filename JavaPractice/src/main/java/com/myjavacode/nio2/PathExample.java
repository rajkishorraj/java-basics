package com.myjavacode.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) {
        Path p = Paths.get("/src/abc.txt");
        System.out.println(Files.exists(p));

        try {
            Files.createFile(p);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try {
            Files.createDirectory(p);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }




    }
}
