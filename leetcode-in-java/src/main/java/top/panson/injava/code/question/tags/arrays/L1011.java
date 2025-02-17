package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-17
 */
public class L1011 {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int left = 0;
            int right = 0;
            for(int i = 0; i < weights.length; i++) {
                left = Math.max(left, weights[i]);
                right += weights[i];
            }
            while(left < right) {
                int mid = left + (right -left) / 2;
                if(canTrans(weights, days, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean canTrans(int[] weights, int days, int minLoad) {
            int count = 1; // 初始化需要的天数为 1，因为至少需要 1 天
            int currentLoad = 0; // 当前船只的载重

            for(int i = 0; i < weights.length; i++) {
                if(currentLoad + weights[i] > minLoad) {
                    count++;
                    if(count > days) {
                        return false;
                    }
                    currentLoad = weights[i];
                } else {
                    currentLoad += weights[i];
                }

            }
            return count <= days; // 如果天数不超过限制，返回 true
        }
    }
}
