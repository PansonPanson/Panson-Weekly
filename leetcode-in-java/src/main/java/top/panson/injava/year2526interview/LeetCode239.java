package top.panson.injava.year2526interview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2025-11-04
 */
public class LeetCode239 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] res = new int[n - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            for(int i = 0; i < nums.length; i++) {
                // 维护单调队列
                while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                // 入队
                deque.offerLast(i);

                // 判断是否出队
                if(i - deque.peekFirst() >= k) {
                    deque.pollFirst();
                }

                if(i >= k - 1) {
                    res[i - k + 1] = nums[deque.peekFirst()];
                }
            }
            return res;
        }
    }
}
