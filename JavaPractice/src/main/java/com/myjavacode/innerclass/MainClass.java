package com.myjavacode.innerclass;

public class MainClass {
    public static void main(String [] args) {
        MyOuter myOuter = new MyOuter();
        myOuter.makeInner();

        MyOuter.MyInner myInner = myOuter.new MyInner();
        myInner.displayInner();
    }
}
