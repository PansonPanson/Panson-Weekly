package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-04-28
 */
public class L41 {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // 1. 将所有小于等于0或者大于n的数字设置为n+1，这些数字不可能是我们要找的第一个缺失的正整数
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0 || nums[i] > n) {
                    nums[i] = n + 1;
                }
            }

            // 2. 将每个数字放到它该在的位置上，即nums[i]应该在nums[nums[i] - 1]的位置
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                if (num <= n && nums[num - 1] > 0) {
                    nums[num - 1] = -nums[num - 1]; // 将nums[num-1]标记为负，表示num已经出现过
                }
            }

            // 3. 找出第一个未标记为负的索引，索引+1就是缺失的第一个正整数
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }

            // 如果都标记为负，说明所有正整数都在数组中，返回n+1
            return n + 1;
        }
    }

}
