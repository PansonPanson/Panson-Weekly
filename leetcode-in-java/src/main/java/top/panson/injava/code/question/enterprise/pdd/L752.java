package top.panson.injava.code.question.enterprise.pdd;

import java.util.*;

/**
 * @author Panson
 * @create 2025-01-23
 */
public class L752 {

    class Solution {
        public int openLock(String[] deadends, String target) {
            // Step 1: 初始化 deadends 和 visited
            Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
            Set<String> visited = new HashSet<>();

            // 如果初始状态是 deadend，直接返回 -1
            if (deadSet.contains("0000")) {
                return -1;
            }

            // 如果目标就是初始状态
            if ("0000".equals(target)) {
                return 0;
            }

            // Step 2: 初始化 BFS 所需的队列
            Queue<String> queue = new LinkedList<>();
            queue.offer("0000");
            visited.add("0000");
            int steps = 0;

            // Step 3: BFS 遍历
            while (!queue.isEmpty()) {
                int size = queue.size(); // 当前层的节点数量
                for (int i = 0; i < size; i++) {
                    String current = queue.poll();

                    // 遍历当前节点的所有可能状态
                    for (String next : getNextStates(current)) {
                        if (deadSet.contains(next) || visited.contains(next)) {
                            continue; // 跳过死亡数字或已访问状态
                        }
                        if (next.equals(target)) {
                            return steps + 1; // 找到目标状态
                        }
                        queue.offer(next);
                        visited.add(next); // 标记为已访问
                    }
                }
                steps++; // 每遍历一层，步数加 1
            }

            // 如果 BFS 遍历结束仍未找到目标状态
            return -1;
        }

        // 生成所有可能的下一个状态
        private List<String> getNextStates(String current) {
            List<String> nextStates = new ArrayList<>();
            char[] chars = current.toCharArray();

            for (int i = 0; i < 4; i++) { // 对 4 个拨轮进行拨动
                char original = chars[i];

                // 向上拨动
                chars[i] = original == '9' ? '0' : (char) (original + 1);
                nextStates.add(new String(chars));

                // 向下拨动
                chars[i] = original == '0' ? '9' : (char) (original - 1);
                nextStates.add(new String(chars));

                // 恢复原状态
                chars[i] = original;
            }

            return nextStates;
        }
    }

}
