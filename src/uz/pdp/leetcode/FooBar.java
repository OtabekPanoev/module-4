package uz.pdp.leetcode;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class FooBar {
    private int n;

    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            printFoo.run();
            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
            printBar.run();
            semaphore1.release();
        }
    }
}

class TestLeetCode {
    public static void main(String[] args) {

        FooBar fooBar = new FooBar(200);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
            }
        });

        executorService.execute(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
            }
        });


        executorService.shutdown();
    }
}