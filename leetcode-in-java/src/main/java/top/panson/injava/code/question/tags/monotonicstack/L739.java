package top.panson.injava.code.question.tags.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2024-03-28
 */
public class L739 {

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] res = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = n - 1; i >= 0; i--) {
                while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return res;
        }
    }
}
