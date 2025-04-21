package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-21
 */
public class L718 {
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            // dp[i][j] 以nums1[i], nums2[j] 结尾的最长公共子序列
            int m = nums1.length;
            int n = nums2.length;
            int max = 0;
            int[][] dp = new int[m + 1][n + 1];

            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    if(nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
            return max;

        }
    }

    class Solution2 {
        public int findLength(int[] nums1, int[] nums2) {
            // dp[i][j] 以nums1[i], nums2[j] 结尾的最长公共子序列
            int m = nums1.length;
            int n = nums2.length;
            int max = 0;
            int[] dp = new int[n + 1];

            for(int i = 1; i <= m; i++) {
                for(int j = n; j > 0; j--) {
                    if(nums1[i - 1] == nums2[j - 1]) {
                        dp[j] = dp[j - 1] + 1;
                    } else {
                        dp[j] = 0;
                    }
                    max = Math.max(dp[j], max);
                }
            }
            return max;

        }
    }
}
