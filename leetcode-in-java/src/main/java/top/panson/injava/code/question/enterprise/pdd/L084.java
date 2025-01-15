package top.panson.injava.code.question.enterprise.pdd;

import java.util.ArrayDeque;

/**
 * @author Panson
 * @create 2025-01-11
 */
public class L084 {

    class Solution {
        public int largestRectangleArea(int[] heights) {
            // 用栈来存储柱子的索引
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int maxArea = 0;
            // 在柱状图末尾添加一个高度为 0 的柱子，确保所有柱子都被处理
            int[] newHeights = new int[heights.length + 1];
            System.arraycopy(heights, 0, newHeights, 0, heights.length);
            newHeights[heights.length] = 0;

            // 遍历每个柱子的高度
            for (int i = 0; i < newHeights.length; i++) {
                // 如果当前柱子的高度小于栈顶柱子的高度，栈顶柱子可以确定其左右边界
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    int h = newHeights[stack.pop()]; // 弹出栈顶柱子的高度
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1; // 宽度计算
                    maxArea = Math.max(maxArea, h * w); // 更新最大面积
                }
                // 当前柱子的索引入栈
                stack.push(i);
            }

            return maxArea;
        }
    }

}
