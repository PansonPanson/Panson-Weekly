package top.panson.injava.tags.twopointers.arraylist;

/**
 * @author Panson
 * @create 2024-06-04
 */
public class L005 {

    class Solution {
        public String longestPalindrome(String s) {
            if(s == null || s.length() <= 1) {
                return s;
            }
            String res = "";
            for(int i = 0; i < s.length(); i++) {
                String palindrome1 = palindrome(s, i, i);
                String palindrome2 = palindrome(s, i, i + 1);
                res = palindrome1.length() > res.length() ? palindrome1 : res;
                res = palindrome2.length() > res.length() ? palindrome2 : res;

            }
            return res;
        }

        public String palindrome(String s, int i, int j) {
            while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            return s.substring(i + 1, j);
        }
    }
}
