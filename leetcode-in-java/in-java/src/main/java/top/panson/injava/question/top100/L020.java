package top.panson.injava.question.top100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 * @create 2022-01-14 11:23
 * @Author: Panson
 */
public class L020 {
    /**
     * 核心思路是利用栈，如果栈顶元素对应的右括号和当前遍历到的括号相同，则是有效的
     * 提前判断字符串长度是否是偶数，可以节约时间
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character peek = stack.isEmpty() ? null : stack.peek();
            Character currentCh = s.charAt(i);
            if(currentCh.equals(map.get(peek))) {
                stack.pop();
            } else {
                stack.push(currentCh);
            }
        }
        return stack.isEmpty();


        //int length = s.length();
        //            if(length % 2 == 1) {
        //                return false;
        //            }
        //            Map<Character, Character> map = new HashMap<>();
        //            map.put(')', '(');
        //            map.put('}', '{');
        //            map.put(']', '[');
        //            Deque<Character> stack = new ArrayDeque<>();
        //            for(int i = 0; i < length; i++) {
        //                char ch = s.charAt(i);
        //                if(map.containsKey(ch)) {
        //                    if(stack.isEmpty() || stack.peek() != map.get(ch)) {
        //                        return false;
        //                    }
        //                    stack.pop();
        //                } else {
        //                    stack.push(ch);
        //                }
        //            }
        //            return stack.isEmpty();
    }
}
