package com.myjavacode.oobasic;

import javax.jws.soap.SOAPBinding;

public class UseI implements I1, I2 {

    public static void main(String [] args) {
        new UseI().go();
    }

    public void go() {
        System.out.println(doStuff());
    }

    @Override
    public int doStuff() {
        return 3;
    }

}
