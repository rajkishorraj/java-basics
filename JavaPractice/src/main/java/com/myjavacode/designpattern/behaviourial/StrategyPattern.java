package com.myjavacode.designpattern.behaviourial;

public class StrategyPattern {

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.makePayment(new CreditCard());

    }

}

class Payment {
    private int amount = 15;

    void makePayment(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(amount);
    }
}

@FunctionalInterface
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCard implements  PaymentStrategy {

    @Override
    public void pay(int amount) {

    }
}

class DebitCard implements  PaymentStrategy {

    @Override
    public void pay(int amount) {

    }
}

