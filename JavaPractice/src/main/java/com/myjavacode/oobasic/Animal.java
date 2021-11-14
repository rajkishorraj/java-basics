package com.myjavacode.oobasic;

public class Animal {
    private String name;

    public Animal() {
        System.out.println("inside animal costructor");
    }
    public Animal(String name) {
        this.name = name;
        System.out.println("inside animal arg const creating a child: " + name);
    }

    public void eat() {
        System.out.println("Animal eat anything generically");
    }
}
