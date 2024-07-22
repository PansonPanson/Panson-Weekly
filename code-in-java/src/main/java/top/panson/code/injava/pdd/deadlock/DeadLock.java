package top.panson.code.injava.pdd.deadlock;

import java.util.concurrent.CountDownLatch;

/**
 * @author Panson
 * @create 2024-07-18
 */
public class DeadLock {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    private static final CountDownLatch countDownLatch1 = new CountDownLatch(1);
    private static final CountDownLatch countDownLatch2 = new CountDownLatch(1);
    public static void main(String[] args) {



        Thread thread1 = new Thread(() -> {
            synchronized(lock1) {
                // 通知线程2继续
                countDownLatch1.countDown();
                try {
                    // 等待线程2启动并锁定lock2
                    countDownLatch2.await();
                } catch (InterruptedException e) {
                    // do something
                }
            }

            synchronized(lock2) {
            }
        });


        Thread thread2 = new Thread(() -> {
            synchronized(lock2) {
                // 通知线程1继续
                countDownLatch2.countDown();
                try {
                    // 等待线程1启动并锁定lock1
                    countDownLatch1.await();
                } catch (InterruptedException e) {
                    // do something
                }
            }
            synchronized(lock1) {

            }
        });


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // do somthing
        }
    }
}
