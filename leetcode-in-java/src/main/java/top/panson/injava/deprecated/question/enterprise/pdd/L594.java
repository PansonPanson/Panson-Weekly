package top.panson.injava.deprecated.question.enterprise.pdd;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-01-12
 */
public class L594 {

    class Solution {
        public int findLHS(int[] nums) {
            Arrays.sort(nums);
            int start = 0;
            int maxLength = 0;
            // 遍历数组，更新右边界
            for(int end = 0; end < nums.length; end++) {
                // 如果数组右边界更新之后，左边界不满足条件，则右移，直到重新满足条件
                while(nums[end] - nums[start] > 1) {
                    start++;
                }
                // 此时 nums[end] - nums[start] <= 0
                // 如果满足条件，更新窗口最大值
                // 如果不满足条件，等窗口右移，下次遍历
                if(nums[end] - nums[start] == 1) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }
            return maxLength;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,2,5,2,3,7};
        System.out.println(new L594().new Solution().findLHS(nums));
    }
}
