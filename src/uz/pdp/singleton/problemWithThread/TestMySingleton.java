package uz.pdp.singleton.problemWithThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMySingleton {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (int i = 0; i < 700; i++) {
            executorService.execute(()-> {
                System.out.println(System.identityHashCode(MySingleton.getInstance()));
            });
        }

       /* MySingleton instance = MySingleton.getInstance();
        MySingleton instance1 = MySingleton.getInstance();
        MySingleton instance2 = MySingleton.getInstance();

        System.out.println(System.identityHashCode(instance));
        System.out.println(System.identityHashCode(instance1));
        System.out.println(System.identityHashCode(instance2));*/

    }

}
