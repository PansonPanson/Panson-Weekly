package top.panson.injava.question.practice.queueandstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @create 2022-05-18 23:47
 * @Author: Panson
 */
public class L232 {

    class MyQueue {

        private Deque<Integer> stack1;
        private Deque<Integer> stack2;

        public MyQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            peek();
            return stack2.pop();
        }

        public int peek() {
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
