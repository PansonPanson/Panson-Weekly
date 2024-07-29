package top.panson.injava.tags.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Panson
 * @create 2024-07-29
 */
public class L384 {
    class Solution {
        int[] nums;
        Random random = new Random();
        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int n = nums.length;
            int[] copy = Arrays.copyOf(nums, n);
            for(int i = 0; i < n; i++) {
                int next = i + random.nextInt(n - i);
                int tmp = copy[i];
                copy[i] = copy[next];
                copy[next] = tmp;
            }
            return copy;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
