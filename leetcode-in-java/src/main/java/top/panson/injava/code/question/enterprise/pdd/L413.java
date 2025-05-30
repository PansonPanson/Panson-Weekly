package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-02-10
 */
public class L413 {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            // dp[i] : 以 dp[i] 为结尾的等差数列的个数
            int n = nums.length;
            if(n < 3) {
                return 0;
            }
            int sum = 0;
            int[] dp = new int[n];
            for(int i = 2; i < n; i++) {
                if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                }
                sum += dp[i];
            }
            return sum;
        }
    }



    class Solution2 {
        public int numberOfArithmeticSlices(int[] nums) {
            // dp[i] : 以 dp[i] 为结尾的等差数列的个数
            int n = nums.length;
            if(n < 3) {
                return 0;
            }
            int sum = 0;
            int[] dp = new int[n];
            // 当前等差数列个数
            int dp_i = 0;

            for(int i = 2; i < n; i++) {
                if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                    dp_i = dp_i + 1;
                } else {
                    dp_i = 0;
                }
                sum += dp_i;
            }
            return sum;
        }
    }
}
