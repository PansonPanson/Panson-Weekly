package top.panson.injava.tags.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2024-03-28
 */
public class L496 {

    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] memory = nextGreaterElement(nums2);
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums2.length; i++) {
                map.put(nums2[i], memory[i]);
            }
            int[] res = new int[nums1.length];
            for(int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }

        public int[] nextGreaterElement(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = n - 1; i >= 0; i--) {
                while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i]);
            }
            return res;
        }
    }
}
