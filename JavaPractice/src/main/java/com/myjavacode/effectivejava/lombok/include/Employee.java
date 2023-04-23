package com.myjavacode.effectivejava.lombok.include;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
    @EqualsAndHashCode.Include
    private String name;
    @EqualsAndHashCode.Include
    private int id;
    private int age;
}
