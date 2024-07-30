package top.panson.injava.tags.math;

import java.util.*;

/**
 * @author Panson
 * @create 2024-07-30
 */
public class L398 {
    class Solution {

        Random random;
        Map<Integer, List<Integer>> map;

        public Solution(int[] nums) {
            map = new HashMap<>();
            random = new Random();
            for(int i = 0; i < nums.length; i++) {
                map.putIfAbsent(nums[i], new ArrayList<Integer>());
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> indices = map.get(target);
            return indices.get(random.nextInt(indices.size()));
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
}
