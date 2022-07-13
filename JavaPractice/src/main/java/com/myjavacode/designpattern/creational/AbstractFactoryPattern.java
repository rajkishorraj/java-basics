package com.myjavacode.designpattern.creational;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = FactoryCreator.getFactory("bank");
        Bank bank = abstractFactory.getBank("hdfc");
    }
}

class FactoryCreator {
    public static AbstractFactory getFactory(String name) {
        if (name.equalsIgnoreCase("bank")) {
            return new BankFactory();
        }
        return new LoanFactory();
    }

}

abstract class AbstractFactory {
    abstract Bank getBank(String name);
    abstract Loan getLoan(String name);
}

class BankFactory extends AbstractFactory {


    @Override
    Loan getLoan(String name) {
        return null;
    }

    @Override
    Bank getBank(String name) {
        if (name.equalsIgnoreCase("icici")) {
            return new ICICI();
        }
        return new HDFC();
    }
}

class LoanFactory extends AbstractFactory {

    @Override
    Loan getLoan(String name) {
        if (name.equalsIgnoreCase("icici")) {
            return new ICICILoan();
        }
        return new HDFCLoan();
    }

    @Override
    Bank getBank(String name) {
        return null;
    }
}




abstract class Bank {
    abstract void getName();
}

class ICICI extends Bank {

    @Override
    void getName() {

    }
}
class HDFC extends Bank {

    @Override
    void getName() {

    }
}

abstract class Loan {
    abstract void getLoanInterest();
}

class ICICILoan extends Loan {


    @Override
    void getLoanInterest() {

    }
}
class HDFCLoan extends Loan {

    @Override
    void getLoanInterest() {

    }
}

