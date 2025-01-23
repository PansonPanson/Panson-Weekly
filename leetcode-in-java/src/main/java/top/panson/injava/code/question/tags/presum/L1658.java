package top.panson.injava.code.question.tags.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2024-07-24
 */
public class L1658 {

    class Solution {
        public int minOperations(int[] nums, int x) {
            // 将问题转换为求中间连续子数组的最大长度，使得子数组的和为 x=sum(nums)−x
            x = -x;
            for (int v : nums) {
                x += v;
            }
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int n = nums.length;
            int ans = 1 << 30;
            for (int i = 0, s = 0; i < n; ++i) {
                s += nums[i];
                map.putIfAbsent(s, i);
                if (map.containsKey(s - x)) {
                    int j = map.get(s - x);
                    ans = Math.min(ans, n - (i - j));
                }
            }
            return ans == 1 << 30 ? -1 : ans;
        }
    }

}
