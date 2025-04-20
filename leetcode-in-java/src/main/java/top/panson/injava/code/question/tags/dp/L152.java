package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-20
 */
public class L152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int[] maxdp = new int[n];
            int[] mindp = new int[n];
            maxdp[0] = nums[0];
            mindp[0] = nums[0];
            int max = nums[0];
            for(int i = 1; i < n; i++) {
                maxdp[i] = Math.max(nums[i], Math.max(maxdp[i - 1] * nums[i], mindp[i - 1] * nums[i]));
                mindp[i] = Math.min(nums[i], Math.min(maxdp[i - 1] * nums[i], mindp[i - 1] * nums[i]));
                max = Math.max(maxdp[i], max);
            }
            return max;
        }
    }

    class Solution1 {
        public int maxProduct(int[] nums) {
            int n = nums.length;

            int maxdp = nums[0];
            int mindp = nums[0];
            int max = nums[0];
            for(int i = 1; i < n; i++) {
                int tmpMax = Math.max(maxdp * nums[i], mindp * nums[i]);
                int tmpMin = Math.min(maxdp * nums[i], mindp * nums[i]);
                maxdp = Math.max(nums[i], tmpMax);
                mindp = Math.min(nums[i], tmpMin);
                max = Math.max(maxdp, max);
            }
            return max;
        }
    }
}
