package top.panson.injava.tags.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2024-03-29
 */
public class L503 {

    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 2 * n - 1; i >= 0; i--) {
                while(!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                    stack.pop();
                }
                res[i % n] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i % n]);
            }
            return res;
        }
    }
}
