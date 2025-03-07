package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-07
 */
public class L45 {
    class Solution {
        public int jump(int[] nums) {
            // 记录跳跃次数
            int jumps = 0;
            // 当前跳跃的边界（当前步数内能到达的最远范围）
            int end = 0;
            // 下一步可到达的最远位置
            int maxReach = 0;

            // 遍历数组，但不包括最后一个元素，因为到达最后一个元素时不需要再跳
            for (int i = 0; i < nums.length - 1; i++) {
                // 更新当前步能到达的最远位置
                maxReach = Math.max(maxReach, i + nums[i]);

                // 当 `i` 到达当前跳跃的边界时，需要进行一次跳跃
                if (i == end) {
                    jumps++;  // 进行跳跃
                    end = maxReach; // 更新新的边界
                }
            }
            return jumps; // 返回最小跳跃次数
        }
    }

}
