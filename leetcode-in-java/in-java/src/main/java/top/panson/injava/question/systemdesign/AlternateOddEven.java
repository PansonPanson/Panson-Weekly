package top.panson.injava.question.systemdesign;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * 交替打印奇偶数
 * @create 2022-03-21 22:51
 * @Author: Panson
 */
public class AlternateOddEven {

    private static Semaphore semaphoreOdd = new Semaphore(1);
    private static Semaphore semaphoreEven = new Semaphore(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        PrintOdd printOdd = new PrintOdd();
        PrintEven printEven = new PrintEven();
        executorService.execute(printOdd);
        executorService.execute(printEven);

    }

    public static class PrintOdd implements Runnable {
        @Override
        public void run() {
            try {
                printOdd();
            } catch (InterruptedException e) {
                // log
            }
        }
    }

    public static class PrintEven implements Runnable {
        @Override
        public void run() {
            try {
                printEven();
            } catch (InterruptedException e) {
                // log
            }
        }
    }

    public static void printOdd() throws InterruptedException {
        for(int i = 1; i <= 100; i+=2) {
            semaphoreOdd.acquire();
            System.out.println(i);
            semaphoreEven.release();
        }
    }

    public static void printEven() throws InterruptedException {
        for(int i = 2; i <= 100; i+=2) {
            semaphoreEven.acquire();
            System.out.println(i);
            semaphoreOdd.release();
        }
    }
}
