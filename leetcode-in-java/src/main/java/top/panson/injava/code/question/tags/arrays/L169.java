package top.panson.injava.code.question.tags.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-03-15
 */
public class L169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int res = nums[0];
            int votes = 0;
            for(int num : nums) {
                if(votes == 0) {
                    res = num;
                }
                votes += num == res ? 1 : -1;
            }
            return res;

        }
    }

    class Solution1 {
        public int majorityElement(int[] nums) {
            int res = nums[0];
            int votes = 0;
            for(int num : nums) {
                if(votes == 0) {
                    res = num;
                }
                votes += (num == res ? 1 : -1);
            }
            return res;
        }
    }

    class Solution2 {
        public int majorityElement(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if(map.get(num) > n/2) {
                    return num;
                }
            }
            return -1;
        }
    }
}
