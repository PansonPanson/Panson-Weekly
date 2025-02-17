package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-17
 */
public class L1332 {
    class Solution {
        public int removePalindromeSub(String s) {
            int left = 0;
            int right = s.length() - 1;
            while(left < right) {
                if(s.charAt(left) != s.charAt(right)) {
                    return 2;
                } else {
                    left++;
                    right--;
                }
            }
            return 1;
        }
    }
}
