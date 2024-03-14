package uz.pdp.l1.multithreading;

public class DealingWithThreads {
    public static void main(String[] args) throws InterruptedException {


//        Runnable runnable = () -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(Thread.currentThread().getName() + " => " + i);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                }
//            }
//        };

        /*Thread th1 = new Thread(runnable);
        th1.start();*/

//        Thread th1 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(Thread.currentThread().getName() + " => " + i);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                }
//            }
//        });
//        th1.start();

        MyThread th1 = new MyThread();

        Thread th2 = new Thread(new MyTask());

        th1.start();
        th2.start();

        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + " => " + "End of Main");
    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " => " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run()  {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " => " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
