package com.myjavacode.modifier.enums;

import lombok.Getter;

@Getter
public enum SingletonEnum {
    INSTANCE(2, "raj", 164);

    private final int age;
    private final String name;
    private final double height;

    SingletonEnum(int age, String name, double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public void leaveTheBuilding() { }
}

