package top.panson.injava.code.question.enterprise.pdd;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2025-01-09
 */
public class L155 {

    class MinStack {

        private Deque<Integer> stack;
        private Deque<Integer> tempStack;

        public MinStack() {
            this.stack = new ArrayDeque<>();
            tempStack = new ArrayDeque<>();
        }

        public void push(int val) {
            stack.push(val);

            if(tempStack.isEmpty() || val < tempStack.peek()) {
                tempStack.push(val);
            } else {
                tempStack.push(tempStack.peek());
            }

        }

        public void pop() {
            stack.pop();
            tempStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return tempStack.peek();
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
