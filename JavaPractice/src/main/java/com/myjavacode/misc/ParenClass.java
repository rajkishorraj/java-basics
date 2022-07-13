package com.myjavacode.misc;

import java.util.HashSet;
import java.util.Set;

public class ParenClass {
    public static Set<Class<? extends ParenClass>> INSTANCES = new HashSet<>();

    ParenClass () {
        synchronized (INSTANCES) {
            if (INSTANCES.contains(this.getClass())) {
                throw new RuntimeException("maximum class creation reached");
            }
            INSTANCES.add(this.getClass());
        }
    }
}
