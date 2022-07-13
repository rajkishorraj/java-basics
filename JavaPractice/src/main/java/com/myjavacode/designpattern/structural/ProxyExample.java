package com.myjavacode.designpattern.structural;

public class ProxyExample {
    public static void main(String[] args) {
        ExpensiveObjectProxy expensiveObjectProxy = new ExpensiveObjectProxy();
        expensiveObjectProxy.process();
    }

}

interface ExpensiveObject {
    void process();
}
class ExpensiveObjectImpl implements ExpensiveObject {

    ExpensiveObjectImpl () {
        someHeaveConfiguration();
    }

    @Override
    public void process() {

    }

    public void someHeaveConfiguration() {

    }
}

class ExpensiveObjectProxy implements ExpensiveObject {
    private ExpensiveObject object;

    @Override
    public void process() {
        if (object == null) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }
}

