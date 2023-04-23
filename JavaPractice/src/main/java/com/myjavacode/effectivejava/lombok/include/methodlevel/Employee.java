package com.myjavacode.effectivejava.lombok.include.methodlevel;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Employee {
    private String name;
    private int id;
    private int age;

    @EqualsAndHashCode.Include
    public boolean hasOddId() {
        return id % 2 != 0;
    }
}
