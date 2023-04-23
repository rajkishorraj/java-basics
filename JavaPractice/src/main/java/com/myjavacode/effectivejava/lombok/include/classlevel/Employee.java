package com.myjavacode.effectivejava.lombok.include.classlevel;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = {"name", "id"})
public class Employee {
    private String name;
    private int id;
    private int age;
}
