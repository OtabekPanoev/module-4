package uz.pdp.l4.executor;

import java.util.Date;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws InterruptedException {

//        m1();
//        m2();
//        m3();
//        m4();
        m5();

    }

    private static void m5() throws InterruptedException {



        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            final int iFinal = i;
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread().getName() + " :: " + iFinal + " task :: " + Thread.activeCount());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            executor.execute(runnable);
        }





        executor.shutdown(); // block the queue
//        executor.shutdownNow();

        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        } else {
            //
        }
//        Thread.sleep(5000);
//        executor.shutdownNow();


        System.out.println("End");
//        System.out.println("before");
//        System.out.println(executor.awaitTermination(5, TimeUnit.SECONDS));
//        System.out.println("after");
//        System.out.println("End");
    }

    private static void m4() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread() + " " + new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("--" +Thread.currentThread().getName() + " finished " + new Date());
        };
//        executor.schedule(runnable, 3, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(runnable, 2, 3, TimeUnit.SECONDS);

//        executor.scheduleWithFixedDelay(runnable, 2, 1, TimeUnit.SECONDS);

        System.out.println("End");
    }

    private static void m3() throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        System.out.println(Thread.activeCount());
        for (int i = 0; i < 200; i++) {
            final int iFinal = i;
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread().getName() + " :: " + iFinal + " task :: " + Thread.activeCount());
                throw new RuntimeException(Thread.currentThread().getName() + " dada dediyu o'ldi");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            };

            executor.execute(runnable);
        }

        Thread.sleep(5000);
        System.out.println(Thread.activeCount());
        System.out.println("End");

    }

    private static void m2() throws InterruptedException {

        System.out.println(Thread.activeCount());
        ExecutorService executor = Executors.newFixedThreadPool(10);


        System.out.println(Thread.activeCount());
        for (int i = 0; i < 100; i++) {
            final int iFinal = i;
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread().getName() + " :: " + iFinal + " task :: " + Thread.activeCount());
            };

            executor.execute(runnable);
//            executor.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " :: " + iFinal + " task :: " + Thread.activeCount());
//            });
        }

        Thread.sleep(1000);
        System.out.println(Thread.activeCount());
        System.out.println("End");
    }

    private static void m1() { // single
        //        Executor
//        ExecutorService
//        ScheduledExecutorService

        Executor executor = Executors.newSingleThreadExecutor();

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread() + " is worked");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        };

        executor.execute(runnable);
        executor.execute(runnable);

        System.out.println(Thread.currentThread().getName() + " End");
    }

}
