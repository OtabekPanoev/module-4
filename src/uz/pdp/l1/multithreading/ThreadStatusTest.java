package uz.pdp.l1.multithreading;

public class ThreadStatusTest {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new MyRunnable2();

        Thread th1 = new Thread(runnable, "Thread => 1");

        System.out.println(th1.getState());

        th1.start();

        System.out.println(th1.getState());

        th1.join(); // main

        System.out.println(th1.getState());

        System.out.println("End");
    }
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
