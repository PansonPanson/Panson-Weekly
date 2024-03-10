package top.panson.injava.question.practice.array;

/**
 * @create 2022-06-03 21:33
 * @Author: Panson
 */
public class L344 {

    class Solution {
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            while(left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
        }
    }
}
