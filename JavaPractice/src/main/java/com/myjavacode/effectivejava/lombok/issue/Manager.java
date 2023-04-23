package com.myjavacode.effectivejava.lombok.issue;

import com.myjavacode.effectivejava.lombok.inheritance.Employee;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Manager {
    private String name;
    private Employee assistantManager;
}
