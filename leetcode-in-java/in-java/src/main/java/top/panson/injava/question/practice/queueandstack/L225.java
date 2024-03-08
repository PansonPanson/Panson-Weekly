package top.panson.injava.question.practice.queueandstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @create 2022-05-19 13:36
 * @Author: Panson
 */
public class L225 {

    class MyStack {

        Deque<Integer> queue;
        private int top;

        public MyStack() {
            queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.offer(x);
            top = x;
        }

        public int pop() {
            int size = queue.size();
            while(size > 2) {
                queue.offer(queue.poll());
                size--;
            }
            top = queue.peek();
            queue.offer(queue.poll());
            return queue.poll();
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
