package uz.pdp.l5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.*;

public class ExtraTask {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int M = 2000;
        int N = 2000;
        int[][] matrix1 = new int[M][N];
        int[][] matrix2 = new int[N][M];

        fillMatrix(matrix1);
        fillMatrix(matrix2);

//        System.out.println("matrix1 = " + Arrays.deepToString(matrix1));
//        System.out.println("matrix2 = " + Arrays.deepToString(matrix2));

        ExecutorService executor = Executors.newFixedThreadPool(8/*Runtime.getRuntime().availableProcessors()*/);
        int[][] res = new int[M][M];

        ArrayList<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
//            MyCallable myCallable = new MyCallable(matrix1, matrix2, res, i);
            MyRunnable myRunnable = new MyRunnable(matrix1, matrix2, res, i);
            Future<?> submit = executor.submit(myRunnable);

            futures.add(submit);
        }

        System.out.println("start");
        for (Future<?> future : futures) {
            future.get();
        }

        System.out.println("end");
//        System.out.println(Arrays.deepToString(res));
        executor.shutdown();


        /*for (int i = 0; i < res.length; i++) {
            MyRunnable myRunnable = new MyRunnable(matrix1, matrix2, res, i);
            executor.execute(myRunnable);
        }
        Thread.sleep(2000);
        System.out.println(Arrays.deepToString(res));
        executor.shutdown();*/
    }

    public static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }
}

class MyRunnable implements Runnable {
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] res;
    private int row;

    public MyRunnable(int[][] matrixA, int[][] matrixB, int[][] res, int row) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.res = res;
        this.row = row;
    }

    @Override
    public void run() {
        for (int i = 0; i < res[row].length; i++) {
            int sum = 0;
            for (int j = 0; j < matrixA[i].length; j++) {
                sum += (matrixA[i][j] * matrixB[j][i]);
            }
            res[row][i] = sum;
        }
    }
}


class MyCallable implements Callable<Boolean> {
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] res;
    private int row;

    public MyCallable(int[][] matrixA, int[][] matrixB, int[][] res, int row) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.res = res;
        this.row = row;
    }

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < res[row].length; i++) {
            int sum = 0;
            for (int j = 0; j < matrixA[i].length; j++) {
                sum += (matrixA[i][j] * matrixB[j][i]);
            }
            res[row][i] = sum;
        }

        return true;
    }
}