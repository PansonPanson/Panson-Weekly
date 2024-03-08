package top.panson.injava.question.top100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @create 2022-01-20 00:54
 * @Author: Panson
 */
public class L155 {

    class MinStack {

        private Deque<Integer> valueStack;
        private Deque<Integer> minValueStack;

        /** initialize your data structure here. */
        public MinStack() {
            this.valueStack = new ArrayDeque<>();
            this.minValueStack = new ArrayDeque<>();
            minValueStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            valueStack.push(x);
            minValueStack.push(Math.min(x, minValueStack.peek()));
        }

        public void pop() {
            valueStack.pop();
            minValueStack.pop();
        }

        public int top() {
            return valueStack.peek();
        }

        public int getMin() {
            return minValueStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
