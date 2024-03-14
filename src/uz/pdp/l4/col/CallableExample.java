package uz.pdp.l4.col;

import java.util.Optional;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {


//        Callable; // task
//        Runnable; // task

        ExecutorService executor = Executors.newFixedThreadPool(2);

//        Runnable runnable = () -> {
//            return "pdp";
//        };
//
//        executor.execute(runnable);

        // myId // 3
        // get data from db // 2

        // logic(myId + db)


        Callable<String> callable1 = () -> {
            TimeUnit.SECONDS.sleep(3);
            return "ketmon teshayev 18 Samarqand uzbek";
        };

        Callable<String> callable2 = () -> {
            TimeUnit.SECONDS.sleep(2);
            return "Data From Postgres";
        };

        Future<String> future1 = executor.submit(callable1);
        Future<String> future2 = executor.submit(callable2);

        System.out.println("...");
        System.out.println("MyId :: " + future1.get());
        System.out.println("---");
        System.out.println("Db :: " + future2.get());
        executor.shutdown();
        System.out.println("end");
    }
}


class MyCallableTask<E> implements Callable<E> {

    @Override
    public E call() throws Exception {

        return null;
    }
}