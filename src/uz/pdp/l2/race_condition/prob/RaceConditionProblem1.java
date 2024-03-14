package uz.pdp.l2.race_condition.prob;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionProblem1 {

    public static void main(String[] args) throws InterruptedException {

        var wallet = new Wallet();

        Runnable r = () -> {
//            System.out.println(Thread.currentThread().getName() + " started incrementing..");
//            for (int j = 0; j < 20_000; j++) {
                wallet.incrementBalance();
//            }
//            System.out.println(Thread.currentThread().getName() + " finished incrementing..");
        };

        Thread th1 = new Thread(r);
        Thread th2 = new Thread(r);
        Thread th3 = new Thread(r);

        th1.start();
        Thread.sleep(100);
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        System.out.println("total: " + wallet.getAmount());
    }
}

class Wallet {
    private volatile long amount = 0;

    private final Lock lock = new ReentrantLock();

    public void incrementBalance() {


        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + " entered");

                if (Thread.currentThread().getName().equals("Thread-0"))
                    wait();

                System.out.println(Thread.currentThread().getName() + " after if");


                notifyAll();
                System.out.println(Thread.currentThread().getName() + " notified");
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }

        }

//        lock.lock();
//        amount += 1;
//        lock.unlock();
    }

    public long getAmount() {
        return amount;
    }
}