package uz.pdp.semafora;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MyBlockingQueue {

    private Semaphore semaphore;

    public MyBlockingQueue(int size) {
        this.semaphore = new Semaphore(size);
    }

    public void enter() throws InterruptedException {
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName() + " entered");
    }

    public void exit() {
        System.out.println(Thread.currentThread().getName() + " exit");
        semaphore.release();
    }

}

class TestQueue {
    public static void main(String[] args) {

        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(3);

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    myBlockingQueue.enter();

                    Thread.sleep(1000);

                    myBlockingQueue.exit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

        service.shutdown();
//        System.out.println("End");
    }
}


