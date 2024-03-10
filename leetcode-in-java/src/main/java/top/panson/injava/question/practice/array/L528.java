package top.panson.injava.question.practice.array;

import java.util.Random;

/**
 * @create 2022-06-05 11:59
 * @Author: Panson
 */
public class L528 {

    class Solution {

        int[] preSum;
        Random random = new Random();
        public Solution(int[] w) {
            preSum = new int[w.length + 1];
            for(int i = 1; i <= w.length; i++) {
                preSum[i] = preSum[i - 1] + w[i - 1];
            }
        }

        public int pickIndex() {
            int n = preSum.length;
            int target = random.nextInt(preSum[n -1]) + 1;
            return leftBoundary(preSum, target) - 1;
        }

        public int leftBoundary(int[] preSum, int target) {
            int left = 0;
            int right = preSum.length - 1;
            while(left <= right) {
                int mid = left + (right - left)/2;
                if(preSum[mid] < target) {
                    left = mid + 1;
                } else if(preSum[mid] == target) {
                    right = mid - 1;
                } else if(preSum[mid] > target) {
                    right = mid - 1;
                }
            }
            // if(left >= preSum.length || preSum[left] != target) {
            //     return -1;
            // }
            return left;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

}
