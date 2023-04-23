package com.myjavacode.effectivejava.lombok.inheritance;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Manager extends Employee {
    private String departmentName;
    private int uid;
}
