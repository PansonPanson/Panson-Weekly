package top.panson.injava.code.question.enterprise.pdd;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-01-10
 */
public class L739 {

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            Map<Integer, Integer> value2Index = new HashMap<>();
            int[] res = new int[temperatures.length];
            int n = temperatures.length;
            for(int i = n - 1; i >= 0; i--) {
                if(stack.isEmpty()) {
                    res[i] = 0;
                } else {
                    while (!stack.isEmpty() && stack.peek() <= temperatures[i]) {
                        stack.pop();
                    }
                    res[i] =  stack.isEmpty() ? 0 : value2Index.get(stack.peek()) - i;
                }
                stack.push(temperatures[i]);
                value2Index.put(temperatures[i], i);

            }
            return res;
        }
    }

    class Solution1 {
        public int[] dailyTemperatures(int[] temperatures) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int[] res = new int[temperatures.length];
            for(int i = 0; i < temperatures.length; i++) {
                // 当前温度比栈顶当天温度高(从栈底到栈顶，由大到小)
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
            return res;
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L739().new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
