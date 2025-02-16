package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-16
 */
public class L875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = 1000000001;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(canFinish(piles, h, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;

        }

        private boolean canFinish(int[] piles, int h, int k) {
            long hours = 0;
            for(int pile : piles) {
                hours += (pile + k - 1) / k;

                if(hours > h) {
                    return false;
                }
            }
            return true;
        }
    }
}
