package top.panson.injava.question.practice.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @create 2022-02-28 23:44
 * @Author: Panson
 */
public class L1116 {

    class ZeroEvenOdd {
        private int n;
        private Semaphore semaphore01;
        private Semaphore semaphore02;
        private Semaphore semaphore03;


        public ZeroEvenOdd(int n) {
            this.n = n;
            semaphore01 = new Semaphore(1);
            semaphore02 = new Semaphore(0);
            semaphore03 = new Semaphore(0);
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for(int i = 1; i <= n; i++) {
                semaphore01.acquire();
                printNumber.accept(0);
                if((i & 1) == 1) {
                    semaphore02.release();
                } else {
                    semaphore03.release();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for(int i = 1; i <= n; i+=2) {
                semaphore02.acquire();
                printNumber.accept(i);
                semaphore01.release();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for(int i = 2; i <= n; i+=2) {
                semaphore03.acquire();
                printNumber.accept(i);
                semaphore01.release();
            }
        }
    }
}
