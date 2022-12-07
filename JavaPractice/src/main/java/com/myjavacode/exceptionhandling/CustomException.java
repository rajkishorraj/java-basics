package com.myjavacode.exceptionhandling;

public class CustomException extends RuntimeException {

    public CustomException(String name) {
        super(name);
    }
}
