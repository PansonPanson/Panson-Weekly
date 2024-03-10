package top.panson.injava.question.practice.array;

import java.util.*;

/**
 * @create 2022-05-20 22:56
 * @Author: Panson
 */
public class L015 {

    public static void main(String[] args) {
        List<List<Integer>> lists = Solution.threeSum(new int[]{-4, -2, -1, 0,1,2});
        System.out.println(lists);
    }

    static class Solution {
        public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; i++) {
                List<List<Integer>> twoSumRes = twoSum(nums, i + 1, nums.length - 1, -nums[i]);
                for (List<Integer> list : twoSumRes) {
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            return res;

        }

        public static List<List<Integer>> twoSum(int[] nums, int l, int h, int target) {
            List<List<Integer>> res = new ArrayList<>();
            while (l < h) {
                int sum = nums[l] + nums[h];
                int left = nums[l];
                int right = nums[h];
                if (sum < target) {
                    while(l < h && nums[l] == left) {
                        l++;
                    }
                } else if(sum > target) {
                    while(l < h && nums[h] == right) {
                        h--;
                    }
                } else  {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    while(l < h && nums[l] == left) {
                        l++;
                    }
                    while(l < h && nums[h] == right) {
                        h--;
                    }
                }
            }
            return res;
        }
    }
}
