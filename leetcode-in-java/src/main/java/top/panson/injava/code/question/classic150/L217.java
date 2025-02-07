package top.panson.injava.code.question.classic150;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Panson
 * @create 2025-02-07
 */
public class L217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int x : nums) {
                if (!set.add(x)) {
                    return true;
                }
            }
            return false;
        }
    }


}
