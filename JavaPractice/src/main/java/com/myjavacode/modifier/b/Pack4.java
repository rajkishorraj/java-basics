package com.myjavacode.modifier.b;

import com.myjavacode.modifier.a.Cert;

public class Pack4 extends Cert{
    public void methodabcd() {
        Cert cert = new Cert();
        this.methodProtected();
//        cert.methodProtectd();
    }
}
