package uz.pdp.l1.multithreading;


public class DealingWithDaemonThreads {
    public static void main(String[] args) {

//        Thread thread = new Thread(() -> {
////            System.out.println("jhdfb");
//        });
//
//        thread.start();
//        System.out.println(Thread.activeCount()); // threadlar soni

//        Thread[] threads = new Thread[Thread.activeCount()];
//        System.out.println(Arrays.toString(threads));
//
//        System.out.println("after...");
//
//        int enumerate = Thread.enumerate(threads);
//        System.out.println("enumerate = " + enumerate);
//
//        System.out.println(Arrays.toString(threads));
//
//        Thread thread = threads[1];
//        System.out.println("thread.isDaemon() = " + thread.isDaemon());

        /*Thread thread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(i + " : " + Thread.activeCount());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });

        thread.setDaemon(true);

        thread.start();

        Thread.sleep(1000);

        System.out.println("End");*/

        System.out.println(Thread.currentThread());
    }
}
