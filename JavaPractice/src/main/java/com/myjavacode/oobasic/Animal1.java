package com.myjavacode.oobasic;


import lombok.Getter;

@Getter
public class Animal1 {
    private String name;
    public Animal1(String name) {
        this.name = name;
        System.out.println("inside arg animal1 constructor");
    }

    public Animal1() {
        this(makeRandomName());
        System.out.println("inside no arg animal1 constructor");
    }

    public static String makeRandomName() {
        int index = (int) (Math.random()*5);
        return new String[]{"floffy", "frido" ,"rover", "spike", "gigo"}[index];
    }

}
