package uz.pdp.l2.sync;

public class TestSync {
    public static void main(String[] args) {

        MySyncClass mySyncClass = new MySyncClass();
        MySyncClass mySyncClass2 = new MySyncClass();

        Runnable runnable = () -> {
            mySyncClass.m1();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable2 = () -> {
            mySyncClass2.m1();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };


        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable2);

        th1.start();
        th2.start();

        System.out.println("Main End");
    }
}

class MySyncClass {

//    private Random random = new Random();
    private static Integer integer = 128;
    private String str = new String("pdp");

    public void m1() {

        synchronized (str) {

            System.out.println(Thread.currentThread().getName() + " entered");

//            num++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " leaved");
        }
    }

}
