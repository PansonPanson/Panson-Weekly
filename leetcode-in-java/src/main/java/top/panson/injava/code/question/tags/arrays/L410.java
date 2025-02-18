package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-18
 */
public class L410 {
    class Solution {
        public int splitArray(int[] nums, int k) {
            int left = 0;
            int right = 0;
            for(int i = 0; i < nums.length; i++) {
                left = Math.max(left, nums[i]);
                right += nums[i];
            }
            while(left < right) {
                int mid = left + (right -left) / 2;
                if(canSplit(nums, k, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }


        private boolean canSplit(int[] nums, int k, int minSum) {
            int count = 1; // 初始化分割数组数量为 1，因为至少需要 1 个数组
            int curNum = 0;

            for(int i = 0; i < nums.length; i++) {
                if(curNum + nums[i] > minSum) {
                    count++;
                    if(count > k) {
                        return false;
                    }
                    curNum = nums[i];
                } else {
                    curNum += nums[i];
                }

            }
            return count <= k; // 如果分割数组数量小于等于 k，返回 true
        }
    }
}
