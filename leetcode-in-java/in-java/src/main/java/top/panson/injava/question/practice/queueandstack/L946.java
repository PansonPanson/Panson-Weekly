package top.panson.injava.question.practice.queueandstack;

/**
 * @create 2022-08-31 11:40
 * @Author: Panson
 */


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 卷王之王卷穿肠提醒您每日一卷已送达，今天你卷了吗？
 * 946.验证栈序列(Medium):点击开卷!!!
 * ######################################################################################
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 提示：
 *     1 <= pushed.length <= 1000
 *     0 <= pushed[i] <= 1000
 *     pushed 的所有元素 互不相同
 *     popped.length == pushed.length
 *     popped 是 pushed 的一个排列
 */
public class L946 {

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = pushed.length;
            for (int i = 0, j = 0; i < n; i++) {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();
        }
    }
}
