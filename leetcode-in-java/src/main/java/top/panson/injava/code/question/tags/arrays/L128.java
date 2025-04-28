package top.panson.injava.code.question.tags.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Panson
 * @create 2025-04-28
 */
public class L128 {
    class Solution {
        public int longestConsecutive(int[] nums) {

            Set<Integer> set = new HashSet<>();
            for(int num : nums) {
                set.add(num);
            }
            int maxLength = 0;
            for(int num : set) {
                if(set.contains(num - 1)) {
                    continue;
                }
                int cur = num;
                int length = 1;
                while(set.contains(cur + 1)) {
                    length++;
                    cur++;
                }
                maxLength = Math.max(maxLength, length);
            }
            return maxLength;
        }
    }
}
