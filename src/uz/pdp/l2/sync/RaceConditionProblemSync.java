package uz.pdp.l2.sync;

import java.util.Arrays;

public class RaceConditionProblemSync {


    public static final int N_ACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;


    public static void main(String[] args) {

        var bank = new Bank(N_ACCOUNTS, INITIAL_BALANCE);

        for ( int i = 0; i < N_ACCOUNTS; i++ ) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while ( true ) {
                        int toAccount = (int) ( bank.size() * Math.random() );
                        double amount = MAX_AMOUNT * MAX_AMOUNT;
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) ( DELAY * Math.random() ));
                    }
                } catch (InterruptedException e) {
                }
            };
            var t = new Thread(r);
            t.start();
        }
    }
}

class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        synchronized (this) {
            while (accounts[from] < amount){
                this.wait();
            }

            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance is %10.2f%n", getTotalBalance());
            this.notifyAll();
        }
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts)
            sum += a;
        return sum;
    }

    public int size() {
        return accounts.length;
    }

}
