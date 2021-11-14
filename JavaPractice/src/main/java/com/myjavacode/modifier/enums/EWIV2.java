package com.myjavacode.modifier.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EWIV2 {
    BIG(8,"A"), LARGE(10, "B"), OVERWHELMING(16, "C");
    private final int ounces;
    private final String name;
}
