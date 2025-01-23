package top.panson.injava.code.question.tags.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2024-07-22
 */
public class L1124 {

    class Solution {
        public int longestWPI(int[] hours) {
            int n = hours.length;
            for(int i = 0; i < n; i++) {
                hours[i] = hours[i] > 8 ? 1 : -1;
            }
            int[] preSum = new int[n + 1];
            for(int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + hours[i];
            }

            int res = 0;
            Map<Integer, Integer> val2Index = new HashMap<>();

            for(int i = 0; i < n; i++) {

                if(preSum[i + 1] > 0) {
                    res = Math.max(res, i + 1);
                } else {
                    if(val2Index.containsKey(preSum[i + 1] - 1)) {
                        res = Math.max(res, i - val2Index.get(preSum[i + 1] - 1));
                    }
                }
                if (!val2Index.containsKey(preSum[i + 1])) {
                    val2Index.put(preSum[i + 1], i);
                }
            }
            return res;
        }
    }
}
