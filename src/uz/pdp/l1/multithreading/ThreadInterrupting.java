package uz.pdp.l1.multithreading;

public class ThreadInterrupting {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new MyRunnable3();
        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);

        th1.start();
        th2.start();

        Thread.sleep(1000);
        th1.interrupt();
        th1.join();

        System.out.println("Main End");

    }
}

class MyRunnable3 implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
           throw new RuntimeException(e);
        }


    }
}
