package com.myjavacode.modifier.b;

import com.myjavacode.modifier.a.Cert;

public class Pack extends Cert {

    public void abc(){
        this.methodProtected();
//        this.methodDefualt();
        Cert cert = new Cert();
//        cert.methodProtected();
    }
}
