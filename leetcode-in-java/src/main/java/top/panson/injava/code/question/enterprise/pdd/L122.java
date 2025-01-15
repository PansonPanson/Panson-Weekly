package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2024-12-30
 */
public class L122 {

    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
    }
}
