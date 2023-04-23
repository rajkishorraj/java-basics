package com.myjavacode.effectivejava.clone;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

@Data
public class Address implements Cloneable {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    public static void main(String[] args) throws IOException {
//        Address address = new Address("kas", "blr");
//
//        Student student = new Student("raj", new Address("sdf", "dsf"));
//
//        student.method(address);

//        Files.createDirectories(Paths.get("/data/dist/m/b/c"), attr);

//        System.out.println("adderess here: " + address.toString());
    }

    
}


