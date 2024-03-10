package top.panson.injava.question.math;

/**
 * @create 2022-06-08 21:27
 * @Author: Panson
 */
public class L268 {

    class Solution {
        public int missingNumber(int[] nums) {
            int sum = 0;
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                sum += nums[i];
            }
            return (n + 1) * n / 2 - sum;
        }

        int missingNumber2(int[] nums) {
            int n = nums.length;
            int res = 0;
            // 先和新补的索引异或一下
            res ^= n;
            // 和其他的元素、索引做异或
            for (int i = 0; i < n; i++)
                res ^= i ^ nums[i];
            return res;
        }
    }
}
