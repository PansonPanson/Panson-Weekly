package top.panson.injava.code.question.tags.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Panson
 * @create 2024-09-02
 */
public class L219 {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int left = 0;
            int right = 0;
            Set<Integer> window = new HashSet<>();
            while(right < nums.length) {
                if(right - left <= k && window.contains(nums[right])) {
                    return true;
                }
                window.add(nums[right]);
                right++;
                if(right - left > k) {
                    window.remove(nums[left]);
                    left++;
                }
            }
            return false;
        }
    }
}
