package com.myjavacode.reflection;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Stack;

public class RefectionExample {
    private String abc;
    private ReflectAbc reflectAbc2 = new ReflectAbc();
    private ReflectAbc reflectAbc = new ReflectAbc();

    public RefectionExample() {
        //first statement will be super
        //after that all instance variable init
        System.out.println("Inside ReflectionExample const: " + reflectAbc.toString());

    }


    public static void main(String[] args) {
//        checkingEquality();
//        new RefectionExample();
        int reflectionClass = ReflectAbc.class.getModifiers();
        System.out.println(reflectionClass);

    }

    public static void inspectMethod() {
        Arrays.stream(ReflectAbc.class.getMethods())
                .forEach(method -> {
                    System.out.println("Name: " + method.getName());
                    System.out.println("Default Value: " + method.getDefaultValue());
                    System.out.println("Declaring Class: " + method.getDeclaringClass());
                    System.out.println("Modifiers: " + method.getModifiers());
                    System.out.println("Exception Type: " + method.getExceptionTypes());
                    System.out.println("Return Type: " + method.getReturnType());
                    System.out.println("Type Params: " + method.getTypeParameters());
                    System.out.println("Anno: " + method.getAnnotations());
                    System.out.println("Param: " + method.getParameters());
                });
    }
    public static void checkingEquality () {
        Integer x = new Integer(7);
        Integer y = new Integer(7);
        if (x == y) {
            System.out.println("equal");
        }
        if (x.equals(y)) {
            System.out.println("equal 2");
        }

        System.out.println("abc".equals("abc"));

        System.out.println("abc" == "abc");

        System.out.println(new String("bcd") == new String("bcd"));
    }
}

@ToString
@AllArgsConstructor
class ReflectAbc {
    private String name;
    private Integer xyz;

    public ReflectAbc() {
        System.out.println("inside ReflectAbc constructor: name: " + name + " xyz: " + xyz);
    }

    public void methodOne() {
        System.out.println("abcOne");
    }

    public void methodTwo() {
        System.out.println("abcTwo");
    }

}

