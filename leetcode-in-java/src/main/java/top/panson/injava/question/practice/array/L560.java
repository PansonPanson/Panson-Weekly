package top.panson.injava.question.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-03-29 23:27
 * @Author: Panson
 */
public class L560 {

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int preSum = 0;
            Map<Integer, Integer> preSumMap = new HashMap<>();
            preSumMap.put(0, 1);
            int count = 0;
            for(int num : nums) {
                preSum += num;
                if(preSumMap.containsKey(preSum - k)) {
                    count += preSumMap.get(preSum - k);
                }
                preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
            }
            return count;
        }
    }
}
