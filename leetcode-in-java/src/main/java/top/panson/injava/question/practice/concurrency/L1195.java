package top.panson.injava.question.practice.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @create 2022-03-05 23:03
 * @Author: Panson
 */
public class L1195 {

    class FizzBuzz {
        private int n;

        private Semaphore buzz;
        private Semaphore fizz;
        private Semaphore number;
        private Semaphore fizzbuzz;


        public FizzBuzz(int n) {
            this.n = n;
            buzz = new Semaphore(0);
            fizz = new Semaphore(0);
            number = new Semaphore(1);
            fizzbuzz = new Semaphore(0);
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    fizz.acquire();
                    printFizz.run();
                    number.release();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    buzz.acquire();
                    printBuzz.run();
                    number.release();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    fizzbuzz.acquire();
                    printFizzBuzz.run();
                    number.release();
                }
            }

        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for(int i = 1; i <= n; i++) {
                number.acquire();
                if(i % 3 == 0 && i % 5 == 0) {
                    fizzbuzz.release();
                } else if(i % 3 == 0) {
                    fizz.release();
                } else if(i % 5 == 0) {
                    buzz.release();
                } else {
                    printNumber.accept(i);
                    number.release();
                }
            }
        }
    }
}
