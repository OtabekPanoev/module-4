package uz.pdp.l5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class TestForkJoinPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println(0x7fff);

        double[] nums = new double[250_0];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.random();
        }

        System.out.println("started");

//        System.out.println(Thread.currentThread().getName() + " => " + Thread.activeCount() + " :: " + from + " : " + to);


        long begin = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        MyForkJoinTask myForkJoinTask = new MyForkJoinTask(nums, 0, nums.length, 100);
        forkJoinPool.invoke(myForkJoinTask);

        Double res = myForkJoinTask.get();// block
        long end = System.currentTimeMillis();

        System.out.println("for execution :: " + (end-begin));


        begin = System.currentTimeMillis();
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0.3)
                sum += nums[i];
        }
        end = System.currentTimeMillis();

        System.out.println("liner execution :: " + (end-begin));




    }

}
