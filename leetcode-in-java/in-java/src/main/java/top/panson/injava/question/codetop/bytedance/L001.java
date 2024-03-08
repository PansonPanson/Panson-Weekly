package top.panson.injava.question.codetop.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-06-12 12:14
 * @Author: Panson
 */
public class L001 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(target - nums[i])) {
                    res[0] = map.get(target - nums[i]);
                    res[1] = i;
                    return res;
                }
                map.put(nums[i], i);
            }
            return res;
        }
    }
}
