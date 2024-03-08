package top.panson.injava.question.practice.array;

/**
 * @create 2022-08-29 11:16
 * @Author: Panson
 */
public class L1470 {


    /**
     * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     * 1234abcd
     * 1a342bcd
     *
     * @param nums
     * @param n
     * @return
     */
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] ans = new int[2 * n];
            for (int i = 0; i < n; i++) {
                ans[2 * i] = nums[i];
                ans[2 * i + 1] = nums[i + n];
            }
            return ans;
        }
    }
}
