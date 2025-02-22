package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-02-21
 */
public class L72 {
    class Solution {
        public int minDistance(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            // i，j 初始化指向最后一个索引
            return dp(s1, m - 1, s2, n - 1);
        }

        // 定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
        int dp(String s1, int i, String s2, int j) {
            // base case
            if (i == -1) return j + 1;
            if (j == -1) return i + 1;

            if (s1.charAt(i) == s2.charAt(j)) {
                // 啥都不做
                return dp(s1, i - 1, s2, j - 1);
            }
            return min(
                    // 插入
                    dp(s1, i, s2, j - 1) + 1,
                    // 删除
                    dp(s1, i - 1, s2, j) + 1,
                    // 替换
                    dp(s1, i - 1, s2, j - 1) + 1
            );
        }

        int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }
}
