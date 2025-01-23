package top.panson.injava.code.question.tags.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2024-07-17
 */
public class L1081 {

    class Solution {
        public String smallestSubsequence(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean[] exist = new boolean[255];
            int[] count = new int[255];
            for(int i = 0; i < s.length(); i++) {
                count[s.charAt(i)]++;
            }

            for(int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                count[cur]--;
                if(exist[cur]) {
                    continue;
                }

                while(!stack.isEmpty() && stack.peek() > cur) {
                    if(count[stack.peek()] == 0) {
                        break;
                    }
                    exist[stack.pop()] = false;
                }
                stack.push(cur);
                exist[cur] = true;
            }

            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            return sb.reverse().toString();

        }
    }
}
