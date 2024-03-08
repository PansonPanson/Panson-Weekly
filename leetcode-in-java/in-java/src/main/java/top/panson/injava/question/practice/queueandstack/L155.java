package top.panson.injava.question.practice.queueandstack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @create 2022-02-23 22:04
 * @Author: Panson
 */
public class L155 {
    class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
