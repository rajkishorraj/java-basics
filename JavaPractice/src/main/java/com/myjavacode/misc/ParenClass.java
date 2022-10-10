package com.myjavacode.misc;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
public class ParenClass {
    public static Set<Class<? extends ParenClass>> INSTANCES = new HashSet<>();

    ParenClass () {
        synchronized (INSTANCES) {
            if (INSTANCES.contains(this.getClass())) {
                throw new RuntimeException("maximum class creation reached " + this.getClass().getSimpleName());
            }
            INSTANCES.add(this.getClass());
        }
    }
}
