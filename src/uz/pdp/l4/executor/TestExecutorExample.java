package uz.pdp.l4.executor;

public class TestExecutorExample {
    public static void main(String[] args) {

        // myGov
        // email
        // Db
        // response

        Runnable runnable = () -> {

        };
        new Thread(runnable).start(); // myGov

        Runnable runnable2 = () -> {

        };
        new Thread(runnable2).start(); // email


        Runnable runnable3 = () -> {

        };
        new Thread(runnable3).start();

    }
}
