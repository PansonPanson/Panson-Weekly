package top.panson.injava.code.question.enterprise.pdd;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-01-18
 */
public class L001 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; ++i) {
                if (hashtable.containsKey(target - nums[i])) {
                    return new int[]{hashtable.get(target - nums[i]), i};
                }
                hashtable.put(nums[i], i);
            }
            return new int[0];
        }
    }


}
