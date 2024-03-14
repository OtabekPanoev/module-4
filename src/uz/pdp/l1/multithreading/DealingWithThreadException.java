package uz.pdp.l1.multithreading;

public class DealingWithThreadException {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                if (Thread.currentThread().getName().equals("Thread-1") && i == 5)
                    throw new RuntimeException("Ehtiyot bo'lda!!!");
            }
        };

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);

        th1.start();
        th2.start();

        System.out.println("Main End");
    }
}
