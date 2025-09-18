package cz.ictpro.threads.exercises;

public class Exercise4 {
    public static void main(String[] args) {
        Account account = new Account(10000);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account.pay(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.transfer(5000);
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.transfer(6000);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class Account {
    private float saldo;
    public Account(int saldo) {
        this.saldo = saldo;
    }
    synchronized void transfer(float amount) {
        saldo += amount;
        notify();
        System.out.println(String.format("Transfer %f, saldo: %f",
                amount, saldo));
    }
    synchronized void pay(float amount) throws
            InterruptedException {
        while (amount > saldo) {
            System.out.println("Not enough money! Waiting ... ");
            wait();
        }
        saldo -= amount;
        System.out.println(String.format("Pay %f, saldo: %f",
                amount, saldo));
    }
}