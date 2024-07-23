package top.panson.injava.tags.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2024-07-23
 */
public class L560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            for(int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int res = 0;
            for(int i = 1; i < preSum.length; i++) {
                if(map.containsKey(preSum[i] - k)) {
                    res += map.get(preSum[i] - k);

                }
                map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
            }
            return res;
        }
    }
}
