package top.panson.injava.tags.linklist.twopointers;

import java.util.Collections;
import java.util.List;

/**
 * @author Panson
 * @create 2024-09-03
 */
public class L2824 {
    class Solution {
        public int countPairs(List<Integer> nums, int target) {
            Collections.sort(nums);
            int left = 0;
            int right = nums.size() - 1;
            int res = 0;
            while(left < right) {
                int sum = nums.get(left) + nums.get(right);
                if(sum < target) {
                    res += right - left;
                    left++;
                } else if(sum >= target) {
                    right--;
                } else {
                    left++;
                }
            }
            return res;
        }
    }
}
