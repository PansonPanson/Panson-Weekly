package top.panson.injava.code.other;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用队列实现一个栈
 *
 * @author Panson
 * @create 2024-05-31
 */
public class Queue2Stack<T> {

    private Deque<T> queue;

    private Deque<T> tmpQueue;

    public Queue2Stack() {
        queue = new ArrayDeque<>();
        tmpQueue = new ArrayDeque<>();
    }

    public void push(T element) {
        queue.offer(element);
    }

    public T pop() {
        if(isEmpty()) {
             throw new RuntimeException("Queue2Stack is empty");
        }
        while(queue.size() > 1) {
            tmpQueue.offer(queue.poll());
        }
        T element = queue.poll();
        Deque<T> tmp = tmpQueue;
        tmpQueue = queue;
        queue = tmp;
        return element;
    }

    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue2Stack is empty");
        }
        while(queue.size() > 1) {
            tmpQueue.offer(queue.poll());
        }
        T element = queue.poll();
        tmpQueue.offer(element);
        Deque<T> tmp = tmpQueue;
        tmpQueue = queue;
        queue = tmp;
        return element;
    }


    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
