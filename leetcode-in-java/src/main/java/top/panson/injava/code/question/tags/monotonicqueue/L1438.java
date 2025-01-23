package top.panson.injava.code.question.tags.monotonicqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2024-04-01
 */
public class L1438 {


    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int n = nums.length;
            Deque<Integer> max = new ArrayDeque<>();
            Deque<Integer> min = new ArrayDeque<>();
            int l = 0;
            int res = 0;
            for(int i = 0; i < n; i++) {
                while(!max.isEmpty() && nums[max.peekLast()] < nums[i]) {
                    max.pollLast();
                }
                while(!min.isEmpty() && nums[min.peekLast()] > nums[i]) {
                    min.pollLast();
                }
                max.offerLast(i);
                min.offerLast(i);
                while(Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > limit) {
                    l++;
                    if(max.peekFirst() < l) {
                        max.pollFirst();
                    }
                    if(min.peekFirst() < l) {
                        min.pollFirst();
                    }
                }
                res = Math.max(res, i - l + 1);
            }
            return res;
        }
    }
}
