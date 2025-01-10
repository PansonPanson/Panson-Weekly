package top.panson.injava.deprecated.question.enterprise.pdd;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2025-01-10
 */
public class L394 {


    class Solution {

        public String decodeString(String s) {

            Deque<Character> stack = new ArrayDeque<>();
            Deque<Character> tempStack = new ArrayDeque<>();
            Deque<Character> stackReverse = new ArrayDeque<>();

            for(char c : s.toCharArray()) {
                if(c != ']') {
                    stack.push(c);
                    continue;
                }
                while(stack.peek() != '[') {
                    tempStack.push(stack.pop());
                }

                stack.pop();
                int repeatTime = 0;
                int base = 1;
                while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    repeatTime += base * (stack.pop() - '0');
                    base *= 10;
                }
                StringBuilder stb  = new StringBuilder();
                while(!tempStack.isEmpty()) {
                    stb.append(tempStack.pop());
                }
                char[] repeatCharArray = stb.toString().toCharArray();
                for(int i = 0; i < repeatTime; i++) {
                    for(int j = 0 ; j < repeatCharArray.length; j++) {
                        stack.push(repeatCharArray[j]);
                    }
                }
            }
            while(!stack.isEmpty()) {
                stackReverse.push(stack.pop());
            }
            StringBuilder res = new StringBuilder();
            while(!stackReverse.isEmpty()) {
                res.append(stackReverse.pop());
            }
            return res.toString();
        }
    }


    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(new L394().new Solution().decodeString(s));
    }

}
