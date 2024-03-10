package top.panson.injava.question.practice.concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @create 2022-03-15 13:34
 * @Author: Panson
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 10; i++) {
//            executorService.execute(() -> {
//                System.out.println("执行任务……" + Thread.currentThread());
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    // do log
//                }
//            });
//        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println("执行任务……" + Thread.currentThread());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // do log
                }
            });
        }
    }
}
