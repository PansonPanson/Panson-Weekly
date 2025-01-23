package top.panson.injava.code.question.tags.presum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2024-07-23
 */
public class L523 {

    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            for(int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            System.out.println(Arrays.toString(preSum));
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 1; i < preSum.length; i++) {
                int remain = preSum[i] % k;
                if(remain == 0 && i >= 2) {
                    return true;
                } else {
                    if(map.containsKey(remain) && (i - map.get(remain)) >= 2) {
                        return true;
                    }
                }

                map.putIfAbsent(remain, i);

            }
            return false;
        }
    }
}
