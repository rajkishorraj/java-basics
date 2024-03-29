package com.myjavacode.effectivejava.clone;

import lombok.Data;

@Data
public class Student implements Cloneable {
    private String name;
    private Address address;

    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Student clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.setAddress(student.getAddress().clone());
        return student;
    }

    public void method(Address address) {
        System.out.println(address.toString());
        address.setStreet("some thing else");
        System.out.println(address.toString());
    }
}
