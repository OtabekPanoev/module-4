package uz.pdp.l2.fieldvisibility;

public class TaskRunner {

    private static int number;
    private static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
//                Thread.yield();
            }

            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Reader().start();
        Thread.sleep(10000);
        number = 42;
        ready = true;
        System.out.println("End");
    }
}
