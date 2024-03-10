package top.panson.injava.question.practice.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @create 2022-03-05 20:51
 * @Author: Panson
 */
public class L1117 {

    class H2O {

        private Semaphore semaphoreH;
        private Semaphore semaphoreO;

        public H2O() {
            semaphoreO = new Semaphore(0);
            semaphoreH = new Semaphore(2);
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            semaphoreH.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            semaphoreO.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            semaphoreO.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            semaphoreH.release(2);
        }
    }
}
