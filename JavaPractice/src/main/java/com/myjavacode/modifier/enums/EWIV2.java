package com.myjavacode.modifier.enums;

import lombok.Getter;

@Getter
public enum EWIV2 {
    BIG(8,"A"), LARGE(10, "B"), OVERWHELMING(16, "C");
    private final int ounces;
    private final String name;

    EWIV2(int ounces, String name) {
        this.ounces = ounces;
        this.name = name;
    }
}
