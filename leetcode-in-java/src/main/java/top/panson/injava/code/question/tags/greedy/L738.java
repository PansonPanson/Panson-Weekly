package top.panson.injava.code.question.tags.greedy;

/**
 * @author Panson
 * @create 2025-04-11
 */
// 738. 单调递增的数字
//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
//给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
//示例 1:
//输入: n = 10
//输出: 9
//示例 2:
//
//输入: n = 1234
//输出: 1234
//示例 3:
//
//输入: n = 332
//输出: 299
//

//提示:
//
//0 <= n <= 109
public class L738 {
    public class Solution {
        public int monotoneIncreasingDigits(int n) {
            char[] chars = Integer.toString(n).toCharArray();
            int index = chars.length;
            for(int i = chars.length - 1; i > 0; i--) {
                if(chars[i - 1] > chars[i]) {
                    chars[i - 1]--;
                    index = i;
                }
            }
            for(int i = index; i < chars.length; i++) {
                chars[i] = '9';
            }
            return Integer.parseInt(new String(chars));
        }
    }
}
