package com.myjavacode.effectivejava.lombok;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = {"id", "age"})
public class Employee {
    private String name;
    private int id;
    private int age;
}
