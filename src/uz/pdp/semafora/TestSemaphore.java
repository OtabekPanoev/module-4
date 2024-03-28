package uz.pdp.semafora;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(6);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.execute(()-> {
                System.out.println(Thread.currentThread().getName() + ": started");
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": finished");
            });
        }

        executor.shutdown();
        Thread.sleep(1000);
        System.out.println("Main");
        System.out.println(semaphore.availablePermits());
//        semaphore.acquire(); // block if not
//        System.out.println(semaphore.tryAcquire()); // non block
//        System.out.println(semaphore.tryAcquire(2)); // non block
        semaphore.acquire(2); //  block
        System.out.println(semaphore.availablePermits());
        System.out.println("End");

    }
}
