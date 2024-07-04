package top.panson.injava.deprecated.other;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 如何用栈实现一个队列
 * @author Panson
 * @create 2024-05-31
 */
public class Stack2Queue<T> {

    private Deque<T> stackA;

    private Deque<T> stackB;

    public Stack2Queue() {
        stackA = new ArrayDeque<>();
        stackB = new ArrayDeque<>();
    }

    public boolean isEmpty() {
        return stackA.isEmpty();
    }

    public void offer(T element) {
        stackA.push(element);
    }

    public T pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack2Queue is empty");
        }
        if(stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException("Stack2Queue is empty");
        }
        if(isEmpty()) {
            throw new RuntimeException("Stack2Queue is empty");
        }
        if(stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }
}
