package top.panson.injava.question.classic150.arrayandstring;

import com.alibaba.fastjson.JSON;

/**
 * @author Panson
 * @create 2023-10-14
 */
public  class L189 {

    static class Solution {
        public static void rotate(int[] nums, int k) {
            //
            k = k % nums.length;
            // 暂存后 k 个数
            int[] tmp = new int[k];
            for(int i = 0; i < k; i++) {
                tmp[i] = nums[nums.length - 1 - i];
            }
            for(int i = nums.length - 1; i >= k; i--) {
                nums[i] = nums[i - k];
            }
            int j = 0;
            for(int i = k - 1; i >= 0; i--) {
                nums[i] = tmp[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        Solution.rotate(nums, 3);
        System.out.println(JSON.toJSONString(nums));
    }
}
