package top.panson.injava.question.practice.array;

/**
 * @create 2022-09-01 10:53
 * @Author: Panson
 */
public class L1475 {

    class Solution {
        public int[] finalPrices(int[] prices) {
            int[] res = new int[prices.length];
            for(int i = 0; i < prices.length; i++) {
                res[i] = prices[i];
            }
            for(int i = 0; i < prices.length; i++) {
                for(int j = i + 1; j < prices.length; j++) {
                    if(prices[j] <= prices[i]) {
                        res[i] = prices[i] - prices[j];
                        break;
                    }
                }
            }
            return res;
        }
    }
    class Solution1 {
        public int[] finalPrices(int[] prices) {
            int[] res = new int[prices.length];
            for(int i = 0; i < prices.length; i++) {
                int discount = 0;
                for(int j = i + 1; j < prices.length; j++) {
                    if(prices[j] <= prices[i]) {
                        discount = prices[j];
                        break;
                    }
                }
                res[i] = prices[i] - discount;
            }
            return res;
        }
    }
}
