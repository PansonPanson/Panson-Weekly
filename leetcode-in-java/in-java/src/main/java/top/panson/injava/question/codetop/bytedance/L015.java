package top.panson.injava.question.codetop.bytedance;

import java.util.*;

/**
 * @create 2022-06-09 23:03
 * @Author: Panson
 */
public class L015 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums == null || nums.length < 3) {
                return res;
            }
            Set<String> set = new HashSet<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 2; i++) {
                int l = i + 1;
                int r = nums.length  - 1;
                while(l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    String str = String.valueOf(nums[i]) + nums[l] + nums[r];
                    if(sum == 0 && !set.contains(str)) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        set.add(str);
                    } else if(sum < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            return res;
        }
    }

    class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums == null || nums.length < 3) {
                return res;
            }
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 2; i++) {
                if(nums[i] > 0) {
                    break;
                }
                if(i > 0 && nums[i] == nums[i - 1]) continue;
                int l = i + 1;
                int r = nums.length  - 1;
                while(l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l + 1]) l++;
                        while(l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if(sum < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            return res;
        }
    }
}
