package com.myjavacode.effectivejava.lombok.issue;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = "manager")
public class Employee {
    private String name;
    private int id;
    private int age;
    private Manager manager;
}
