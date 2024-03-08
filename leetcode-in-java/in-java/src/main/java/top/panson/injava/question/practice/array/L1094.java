package top.panson.injava.question.practice.array;

/**
 * @create 2022-06-04 12:46
 * @Author: Panson
 */
public class L1094 {

    class Solution {
        int[] dif;
        int[] sum;
        public boolean carPooling(int[][] trips, int capacity) {
            dif = new int[1001];
            sum = new int[1001];
            for(int[] trip : trips) {
                dif[trip[1]] += trip[0];
                dif[trip[2]] -= trip[0];
            }
            sum[0] = dif[0];
            for(int i = 1; i < dif.length; i++) {
                sum[i] = sum[i - 1] + dif[i];
            }

            for(int num : sum) {
                if(num > capacity) {
                    return false;
                }
            }
            return true;
        }
    }
}
