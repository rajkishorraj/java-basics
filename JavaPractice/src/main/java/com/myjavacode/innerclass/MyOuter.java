package com.myjavacode.innerclass;

public class MyOuter {
    private int xyz = 7;

    private void display() {
        System.out.println("this is MyOuter class");
    }

    public void makeInner() {
        MyInner myInner = new MyInner();
        myInner.seeOuter();
    }

    class MyInner {

        public void seeOuter () {

            System.out.println("the value of syz: " + xyz);
        }

        public void displayInner() {
            display();
        }
    }
}
