package top.panson.injava.question.practice.array;/**
* @create 2022-06-03 22:20
* @Author: Panson
*/
public class L005 {

    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for(int i = 0; i < s.length(); i++) {
                String res1 = palindrome(s, i, i);
                String res2 = palindrome(s, i, i + 1);
                res = res1.length() > res.length() ? res1 : res;
                res = res2.length() > res.length() ? res2 : res;
            }
            return res;
        }

        public String palindrome(String s, int left, int right) {
            String res = "";
            while(left >= 0 && right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return s.substring(left + 1, right);
        }
    }
}
