package com.myjavacode.file;

import java.io.File;
import java.io.IOException;

public class Write1 {

    public static void main(String [] args) throws IOException {
        File file = new File("filename.txt");
        System.out.println(file.exists());
        System.out.println(file.createNewFile());
        System.out.println(file.exists());

    }
}
