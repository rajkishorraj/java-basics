package com.myjavacode.misc;

public class ImmutableExample {

    public static void main(String[] args) throws ClassNotFoundException {
        String ss = "dssf";

        ss.toUpperCase(); //immutablitly mean once you created the object you can not modify that object
        //however you can change the refrence variable to refer to some other object
        //if you do try to modify the object a new object will be created but that object will not get moidifed

        System.out.println(ss + " ");

        new ChildClassA();
        new ChildClassB();
        new ParenClass();
//        new ChildClassA();

        Class<?> childClassA = Class.forName("com.myjavacode.misc.ChildClassA");
        System.out.println(childClassA.toString());


    }
}
