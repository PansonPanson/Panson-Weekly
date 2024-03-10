package top.panson.injava.question.top100;

/**
 * 最长回文数
 *
 * @create 2022-01-12 23:36
 * @Author: Panson
 */
public class L005 {


    static class Solution {

        public static void main(String[] args) {
            System.out.println(longestPalindrome("ababcaba"));
        }

        /**
         * 动态规划：以一个二维数组存储字符下标 i 到 j 截取的子串是否是否是回文数
         * 列存储时，下三角区域是已知数据，可以状态转移，仅需要再判断遍历到的两个首尾字符是否相等
         * @param s
         * @return
         */
        public static String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            int maxLen = 1;
            int begin = 0;
            char[] cs = s.toCharArray();
            // dp[i][j]:表示s[i][j]是否是回文串
            boolean[][] dp = new boolean[len][len];
            // 初始化：单独一个字符肯定是回文子串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            // 经验：dp区域是正方形的话，通常左下角区域无效不需要再填，因为走过的区域不用再走
            for (int j = 1; j < len; j++) { // 上三角区域，按列从上到下填
                for (int i = 0; i < j; i++) {
                    // 首尾不相等时，必不是回文串
                    if (cs[i] != cs[j]) {
                        dp[i][j] = false;
                    } else {
                        // 首尾相等时，有2种情况
                        // 情况1：s[i...j]长度不超过3，不用检查必为回文串
                        // 情况2：s[i...j]长度大于3，由s[i+1...j-1]来判断
                        dp[i][j] = j - i + 1 <= 3 || dp[i + 1][j - 1];
                    }
                    // 更新max和begin
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }
    }
}
