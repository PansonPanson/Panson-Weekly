package top.panson.injava.deprecated.question.enterprise.pdd;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-01-05
 */
public class L020 {

    class Solution {
        public boolean isValid(String s) {
            // 使用栈：if 空，push, cur == top 映射，pop, i++
            // cur != top, push i++.
            // if i == length , return stack.isEmpty

            int n = s.length();
            if(n % 2 != 0) {
                return false;
            }
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('{', '}');
            map.put('[', ']');
            Deque<Character> stack = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                Character ch = s.charAt(i);
                if(stack.isEmpty()) {
                    stack.push(ch);
                    continue;
                }
                Character top = stack.peek();
                if(ch.equals(map.get(top))) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }
    }
}
