package uz.pdp.l4.col;

import java.util.Random;
import java.util.concurrent.*;

public class FutureMethods {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        Callable<String> callable1 = () -> {
            Thread.sleep(3000);
            if (new Random().nextBoolean())
                throw new RuntimeException("nnn");
            return "Response1";
        };

        Callable<String> callable2 = () -> {
            Thread.sleep(2000);
            return "Response2";
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> future1 = executor.submit(callable1);
        Future<String> future2 = executor.submit(callable2);

//        if (!future1.isDone()) {
//            System.out.println("Future1 is working");
//            Thread.sleep(1000);
//            if (!future1.isDone())
//                throw new RuntimeException("hsdgdjhs");
//        }

//        TimeUnit.SECONDS.sleep(2);
//        if (!future1.isDone()) {
//            future1.cancel(true);
//        }

//        System.out.println(future1.get());

//        if (future1.isCancelled()) {
//            System.out.println("Api did not responded");
//        } else {
//            System.out.println("Api successfully responded");
//            System.out.println("Res :: " + future1.get());
//        }


        executor.shutdown();
        System.out.println("End");

    }

}
