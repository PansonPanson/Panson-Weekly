package top.panson.injava.code.question.enterprise.pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Panson
 * @create 2025-01-22
 */
public class L015 {

    class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;

            for(int i = 0; i < n; i++) {
                // 跳过重复的数字
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int left = i + 1;
                int right = n - 1;

                while(left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // 跳过重复的数字
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if(sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return res;
        }
    }
}
