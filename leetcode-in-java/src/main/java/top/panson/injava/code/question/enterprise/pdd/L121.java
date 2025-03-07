package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2024-12-28
 */
public class L121 {

    class Solution1 {
        public int maxProfit(int[] prices) {
            // 遍历的时候记录当天之前买入的最低价格，如果今天卖出，利润就是 今天的价格  - 当天之前的历史最低价格
            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;
            for(int i = 0; i < prices.length; i++) {
                if(prices[i] < minPrice) {
                    minPrice = prices[i];
                } else {
                    maxProfit = Math.max(maxProfit, prices[i] - minPrice);
                }
            }
            return maxProfit;
        }
    }


    class Solution2 {
        public int maxProfit(int[] prices) {
            // 遍历的时候记录当天之前买入的最低价格，如果今天卖出，利润就是 今天的价格  - 当天之前的历史最低价格
            int cost = Integer.MAX_VALUE;
            int maxProfit = 0;
            for(int i = 0; i < prices.length; i++) {
                cost = Math.min(cost, prices[i]);
                maxProfit = Math.max(maxProfit, prices[i] - cost);
            }
            return maxProfit;
        }
    }
}
