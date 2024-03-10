package top.panson.injava.question.practice.greedy;

/**
 * @create 2022-09-24 14:25
 * @Author: Panson
 */
public class L122 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            // dp 存储第 i 天出售或者购买的最大利润
            // 当天买入所获利润
            int dpi0 = 0;
            // 当天卖出所获利润
            int dpi1 = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                int tmp = dpi0;
                // 第 i 天卖出
                dpi0 = Math.max(dpi0, dpi1 + prices[i]);
                // 第 i 天买入
                dpi1 = Math.max(dpi1, tmp - prices[i]);
            }
            return dpi0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        Solution solution = new Solution();
        int i = solution.maxProfit(arr);
        System.out.println(i);
    }
}
