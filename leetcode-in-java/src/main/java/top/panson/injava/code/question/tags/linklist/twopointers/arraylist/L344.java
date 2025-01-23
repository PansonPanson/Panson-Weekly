package top.panson.injava.code.question.tags.linklist.twopointers.arraylist;

/**
 * @author Panson
 * @create 2024-06-03
 */
public class L344 {

    class Solution {
        public void reverseString(char[] s) {
            int n = s.length;
            int p1 = 0;
            int p2 = n - 1;
            while(p1 < p2) {
                char tmp = s[p1];
                s[p1] = s[p2];
                s[p2] = tmp;
                p1++;
                p2--;
            }
        }
    }
}
