package top.panson.injava.tags.presum;

/**
 * @author Panson
 * @create 2024-07-21
 */
public class L724 {

    class Solution {
        public int pivotIndex(int[] nums) {
            int[] preSum = new int[nums.length];
            preSum[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            if(preSum[nums.length - 1] - nums[0] == 0) {
                return 0;
            }
            for(int i = 1; i < nums.length; i++) {
                if(preSum[i - 1] * 2 == preSum[nums.length - 1] - nums[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
}
