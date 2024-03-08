package top.panson.injava.question.practice.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1114. 按序打印
 *
 * @create 2022-02-12 15:30
 * @Author: Panson
 */
public class L1114 {
    // 使用 Semaphore
    class Foo {

        private Semaphore semaphore12;
        private Semaphore semaphore23;


        public Foo() {
            semaphore12 = new Semaphore(0);
            semaphore23 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore12.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore12.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            semaphore23.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphore23.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }


    // 使用 AtomicInteger
    class Foo1 {

        private AtomicInteger firstAtomicInteger;
        private AtomicInteger secondAtomicInteger;
        public Foo1() {
            firstAtomicInteger = new AtomicInteger(0);
            secondAtomicInteger = new AtomicInteger(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstAtomicInteger.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while(firstAtomicInteger.get() != 1) {
                // waiting
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondAtomicInteger.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while(secondAtomicInteger.get() != 1) {
                // waiting
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
