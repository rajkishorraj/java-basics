package com.myjavacode.modifier.a;

public class Cert {

    public void methodPublic(){};
    protected void methodProtected(){};
    void methodDefault(){};
    public void methodImpl(){
        this.methodDefault();
    }
}
