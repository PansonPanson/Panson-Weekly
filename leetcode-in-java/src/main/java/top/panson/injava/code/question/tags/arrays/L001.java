package top.panson.injava.code.question.tags.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-04-28
 */
public class L001 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> index2Val = new HashMap<>();
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                if(index2Val.containsKey(target - nums[i])) {
                    return new int[]{i, index2Val.get(target - nums[i])};
                }
                index2Val.put(nums[i], i);
            }
            return null;
        }
    }
}
