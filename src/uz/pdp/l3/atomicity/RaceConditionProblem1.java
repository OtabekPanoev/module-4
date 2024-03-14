package uz.pdp.l3.atomicity;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class RaceConditionProblem1 {

    public static void main(String[] args) throws InterruptedException {

        /*int a = 0;
        int s = a++;
        System.out.println(s);

        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.getAndIncrement()); */

        var wallet = new Wallet();

        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " started incrementing..");
            for (int j = 0; j < 20_000; j++) {
                wallet.incrementBalance();
            }
            System.out.println(Thread.currentThread().getName() + " finished incrementing..");
        };

        Thread th1 = new Thread(r);
        Thread th2 = new Thread(r);
        Thread th3 = new Thread(r);

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();
        System.out.println("total: " + wallet.getAmount());
    }
}

class Wallet {
    private AtomicLong atomicAmount = new AtomicLong();

    public void incrementBalance() {
        long l = atomicAmount.getAndIncrement();
    }

    public long getAmount() {
        return atomicAmount.get();
    }
}