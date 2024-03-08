package top.panson.injava.question.practice.concurrency;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @create 2022-05-09 20:42
 * @Author: Panson
 */
public class L1118 {

    class BoundedBlockingQueue {

        private volatile int  capacity;
        private Deque<Integer> queue;
        public BoundedBlockingQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new ArrayDeque<>();
        }

        public synchronized void enqueue(int element) throws InterruptedException {
            while(queue.size() == capacity) {
                this.wait();
            }
            queue.push(element);
            this.notifyAll();
        }

        public synchronized int dequeue() throws InterruptedException {
            while(queue.isEmpty()) {
                this.wait();
            }
            Integer pop = queue.pop();
            this.notifyAll();
            return pop;
        }

        public synchronized int getSize() {
            return queue.size();
        }
    }


    class BoundedBlockingQueue1 {
        private volatile int capacity;
        private Deque<Integer> queue;
        private AtomicInteger size = new AtomicInteger();
        private ReentrantLock lock = new ReentrantLock();
        private Condition producer = lock.newCondition();
        private Condition consumer = lock.newCondition();

        public BoundedBlockingQueue1(int capacity) {
            this.capacity = capacity;
            this.queue = new ArrayDeque<>();
        }

        public void enqueue(int element) throws InterruptedException {
            lock.lock();
            try {
                while(size.get() >= capacity) {
                    producer.await();
                }
                queue.push(element);
                size.incrementAndGet();
                consumer.signalAll();
            } catch (Exception e) {
                // log
            } finally {
                lock.unlock();
            }
        }

        public int dequeue() throws InterruptedException {
            lock.lock();
            try {
                while(size.get() == 0) {
                    consumer.await();
                }
                Integer pop = queue.pop();
                size.decrementAndGet();
                producer.signalAll();
                return pop;
            } finally {
                lock.unlock();
            }
        }

        public int getSize() {
            return size.get();
        }
    }
}
