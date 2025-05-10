package top.panson.injava.code.question.tags.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-05-10
 */
public class L020 {
    class Solution {
        public boolean isValid(String s) {

            Deque<Character> stack = new ArrayDeque<>();
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('{', '}');
            map.put('[', ']');
            for(int i = 0; i < s.length(); i++) {
                Character cur = s.charAt(i);
                if(stack.isEmpty()) {
                    stack.push(cur);
                    continue;
                }
                Character top = stack.peek();
                if(cur.equals(map.get(top))) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
            return stack.isEmpty();
        }
    }
}
