package top.panson.injava.tags.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2024-07-22
 */
public class L525 {

    class Solution {
        public int findMaxLength(int[] nums) {

            int res = 0;
            int n = nums.length;

            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            Map<Integer, Integer> val2Index = new HashMap<>();

            for(int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
            }
            for(int i = 0; i < preSum.length; i++) {
                if(!val2Index.containsKey(preSum[i])) {
                    val2Index.put(preSum[i], i);
                } else {
                    res = Math.max(res, i - val2Index.get(preSum[i]));
                }
            }
            return res;
        }
    }
}
