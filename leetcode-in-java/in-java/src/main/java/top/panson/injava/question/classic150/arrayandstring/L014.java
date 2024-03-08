package top.panson.injava.question.classic150.arrayandstring;

/**
 * @author Panson
 * @create 2023-12-25
 */
public class L014 {

    static class Solution {
        public static String longestCommonPrefix(String[] strs) {
            int n = strs.length;
            if(n == 0) {
                return "";
            }

            int ret = 0;

            for(int i = 0; i < strs[0].length(); i++) {
                char cur = strs[0].charAt(i);

                for(int j = 1; j < n; j++) {
                    if(ret < i || strs[j].length() - 1 < i || cur != strs[j].charAt(i)) {
                        break;
                    }
                    if(j == n - 1) {
                        ret++;
                    }
                }
            }
            return strs[0].substring(0, ret);
        }
    }


    public static void main(String[] args) {
        String[] strs = {"cir","car"};
        String s = Solution.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
