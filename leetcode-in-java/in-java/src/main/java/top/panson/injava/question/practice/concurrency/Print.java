package top.panson.injava.question.practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 交替打印字母与数字
 * @create 2022-05-05 20:21
 * @Author: Panson
 */
public class Print {
    static Semaphore printNumSemaphore = new Semaphore(1);
    static Semaphore printLetterSemaphore = new Semaphore(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        PrintNumber printNumber = new PrintNumber();
        PrintLetter printLetter = new PrintLetter();

        executorService.execute(printNumber);
        executorService.execute(printLetter);

    }

    public static class PrintNumber implements Runnable {

        @Override
        public void run() {
            try {
                for(int i = 1; i < 100; i++) {
                    printNumSemaphore.acquire();
                    System.out.print(i);
                    printLetterSemaphore.release();
                }

            } catch (InterruptedException e) {
                // log
            }
        }
    }

    public static class PrintLetter implements Runnable {

        @Override
        public void run() {
            try {
                char start = 'A';
                for(int i = 0; i < 26; i++) {
                    printLetterSemaphore.acquire();
                    System.out.print((char)(start + i));
                    printNumSemaphore.release();
                }

            } catch (InterruptedException e) {
                // log
            }
        }
    }
}
