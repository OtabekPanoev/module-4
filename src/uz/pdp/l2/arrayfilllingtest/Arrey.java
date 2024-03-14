package uz.pdp.l2.arrayfilllingtest;

import java.util.Random;

public class Arrey {
    static Random random = new Random();
    static int[][] ints = new int[10000][10000];

    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                ints[i][j] = random.nextInt();
            }
        }
        System.out.println((System.currentTimeMillis()-l));
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 2000; i++) {
                for (int j = 0; j < 10000 ; j++) {
                    ints[i][j] = random.nextInt(100);
                }
            }
        });

        Thread thread2 = new Thread(()->{
            for (int i = 2000; i < 4000; i++) {
                for (int j = 0; j < 10000 ; j++) {
                    ints[i][j] = random.nextInt(100);
                }
            }
        });
        Thread thread3 = new Thread(()->{
            for (int i = 4000; i < 6000; i++) {
                for (int j = 0; j < 10000 ; j++) {
                    ints[i][j] = random.nextInt(100);
                }
            }
        });
        Thread thread4 = new Thread(()->{
            for (int i = 6000; i < 8000; i++) {
                for (int j = 0; j < 10000 ; j++) {
                    ints[i][j] = random.nextInt(100);
                }
            }
        });
        Thread thread5 = new Thread(()->{
            for (int i = 8000; i < 10000; i++) {
                for (int j = 0; j < 10000 ; j++) {
                    ints[i][j] = random.nextInt(100);
                }
            }
        });
        long l1 = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        long and = System.currentTimeMillis();
        System.out.println((and-l1));
    }
}