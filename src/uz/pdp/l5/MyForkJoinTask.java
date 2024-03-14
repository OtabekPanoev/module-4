package uz.pdp.l5;

import java.util.concurrent.RecursiveTask;

public class MyForkJoinTask extends RecursiveTask<Double> {

    private double[] nums;
    private int from;
    private int to;
    private int limit;

    public MyForkJoinTask(double[] nums, int from, int to, int limit) {
        this.nums = nums;
        this.from = from;
        this.to = to;
        this.limit = limit;
    }

    @Override
    protected Double compute() {
        System.out.println(Thread.currentThread().getName() + " => " + Thread.activeCount() + " :: " + from + " : " + to);

        if (to - from <= limit) {
            double sum = 0;
            for (int i = from; i < to; i++) {
                if (nums[i] < 0.3)
                    sum += nums[i];
            }
            return sum;
        } else {

            try {
                int middle = from + (to - from) / 2;

                MyForkJoinTask myForkJoinTask1 = new MyForkJoinTask(nums, from, middle, limit);
                MyForkJoinTask myForkJoinTask2 = new MyForkJoinTask(nums, middle, to, limit);

                invokeAll(myForkJoinTask1, myForkJoinTask2); // block

                return myForkJoinTask1.get() + myForkJoinTask2.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
