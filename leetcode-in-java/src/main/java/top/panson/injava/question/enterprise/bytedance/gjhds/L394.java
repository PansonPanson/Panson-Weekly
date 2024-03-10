package top.panson.injava.question.enterprise.bytedance.gjhds;

import java.util.Stack;

/**
 * @create 2023-06-02 23:54
 * @Author: Panson
 */
public class L394 {

    public static void main(String[] args) {
        String test = "3[a2[c]]";
        String s = decodeString(test);
        System.out.print("s");
    }

    public static String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        /**
         * 示例 1：
         *
         * 输入：s = "3[a]2[bc]"
         * 输出："aaabcbc"
         * 示例 2：
         *
         * 输入：s = "3[a2[c]]"
         * 输出："accaccacc"
         * 示例 3：
         *
         * 输入：s = "2[abc]3[cd]ef"
         * 输出："abcabccdcdcdef"
         * 示例 4：
         *
         * 输入：s = "abc3[cd]xyz"
         * 输出："abccdcdcdxyz"
         *
         */
        for (char c : s.toCharArray()) {
            // 把所有的字母push进去，除了]
            if (c != ']') {
                stack.push(c);
            } else {
                // step 1: 取出[] 内的字符串
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }

                // [ ]内的字符串
                String sub = sb.toString();
                stack.pop(); // 去除[


                // step 2: 获取倍数数字
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }

                //倍数
                int count = Integer.valueOf(sb.toString());


                //step 3: 根据倍数把字母再push回去
                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }

        //把栈里面所有的字母取出来，完事L('ω')┘三└('ω')｣
        StringBuilder retv = new StringBuilder();
        while (!stack.isEmpty()) {
            retv.insert(0, stack.pop());
        }

        return retv.toString();
    }
}
