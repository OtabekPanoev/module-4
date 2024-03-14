package uz.pdp.l2.fieldvisibility;

public class WithoutVolatile {
    public static void main(String[] args) throws InterruptedException {
        var myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);

        thread1.start();
        thread2.start();
        Thread.sleep(4000);
        myRunnable.stop();

        System.out.println("end");
    }
}

class MyRunnable implements Runnable {

    private volatile boolean active;
    @Override
    public void run() {
        active = true;
        while (active){
            System.out.println(Thread.currentThread());
        }
        System.out.println(Thread.currentThread()+"::::::::: Finished!!!");
    }

    public void stop() {
        active = false;
    }
}
