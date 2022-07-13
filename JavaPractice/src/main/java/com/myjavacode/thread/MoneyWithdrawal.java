package com.myjavacode.thread;

import lombok.Getter;

public class MoneyWithdrawal {
    public static void main(String [] args) {
        MoneyWithdrawal moneyWithdrawal = new MoneyWithdrawal();
        Account account = new Account();

        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
//                moneyWithdrawal.makeWithDraw(account, 10);
                moneyWithdrawal.makeWithDrawSync(account, 10);
                if (account.getBalance() < 0) {
                    System.out.println("account over withdrawn");
                }
            }
        };

        Thread one = new Thread(runnable);
        Thread two = new Thread(runnable);

        one.setName("fred");
        two.setName("lucy");

        one.start();
        two.start();

    }

    public void makeWithDraw(Account account, int amount){
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");

//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException exception) {}

            account.withDraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");

        } else {
            System.out.println("Not enough money in account for " + Thread.currentThread().getName() + " to withdraw " +
                    account.getBalance());

        }
    }

    public synchronized void makeWithDrawSync(Account account, int amount){
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException exception) {}

            account.withDraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");

        } else {
            System.out.println("Not enough money in account for " + Thread.currentThread().getName() + " to withdraw " +
                    account.getBalance());

        }
    }
}

@Getter
class Account {
    private int balance = 50;

    public void withDraw(int amount) {
        balance = balance - amount;
    }
}
