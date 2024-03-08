package top.panson.injava.question.practice.list.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-05-20 01:13
 * @Author: Panson
 */
public class TwoSum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            Map<Integer, Integer> valueToIndexMap = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if(valueToIndexMap.containsKey(target - nums[i])) {
                    res[0] = valueToIndexMap.get(target - nums[i]);
                    res[1] = i;
                    return res;
                }
                valueToIndexMap.put(nums[i], i);
            }
            return res;
        }
    }}
