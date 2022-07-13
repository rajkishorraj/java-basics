package com.myjavacode.modifier.enums;

import lombok.Getter;

@Getter
//@AllArgsConstructor
public enum EnumWithInstanceVariable {
    BIG(8), LARGE(10), OVERWHELMING(16);
    private final int ounces;

    EnumWithInstanceVariable(int ounces) {
        this.ounces = ounces;
    }
}
