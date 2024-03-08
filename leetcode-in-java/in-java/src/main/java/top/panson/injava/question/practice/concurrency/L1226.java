package top.panson.injava.question.practice.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @create 2022-05-09 18:51
 * @Author: Panson
 */
public class L1226 {
    class DiningPhilosophers {

        ReentrantLock[] locks = {
        new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock()
        };

        Semaphore semaphore = new Semaphore(4);

        public DiningPhilosophers() {

        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {

            semaphore.acquire();
            int index = (philosopher + 1) % 5;
            locks[index].lock();
            locks[philosopher].lock();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            locks[index].unlock();
            locks[philosopher].unlock();
            semaphore.release();
        }
    }
}
