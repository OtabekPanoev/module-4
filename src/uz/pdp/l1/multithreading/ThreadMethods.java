package uz.pdp.l1.multithreading;

public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new MyRunnable3();

        Thread th1 = new Thread(runnable, "Thread => 1");
        Thread th2 = new Thread(runnable, "Thread => 2");

        th1.start();

        System.out.println("before join");
        th1.join(); // main

        th2.start();

        Thread.sleep(100);
        System.out.println("End");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
