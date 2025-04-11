package top.panson.injava.code.question.tags.greedy;

/**
 * @author Panson
 * @create 2025-04-11
 */
public class L45 {
    // 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

// 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

// 0 <= j <= nums[i]
// i + j < n
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

    // [2,3,1,1,4]
    class Solution {
        public int jump(int[] nums) {
            if(nums.length <= 1) {
                return 0;
            }
            int start = 0;
            int end = nums[0];
            int steps = 1;
            while(end < nums.length - 1) {
                int tmpEnd = end;
                for(int j = start; j <= end; j++) {
                    if(nums[j] + j >= tmpEnd) {
                        tmpEnd = nums[j] + j;
                    }
                }
                start = end + 1;
                end = tmpEnd;
                steps++;
            }

            return steps;
        }
    }


    class Solution1 {
        public int jump(int[] nums) {
            int jumpCount = 0;          // 总共跳了几次
            int currentJumpEnd = 0;     // 当前这一跳的“跳跃终点”
            int maxReach = 0;           // 在当前跳跃范围内，能到的最远位置

            for (int i = 0; i < nums.length; i++) {
                // 每走一步，看看最远能到哪里
                maxReach = Math.max(maxReach, i + nums[i]);
                // 到了当前步数能跳到最远的点，但是还没到终点
                if (i == currentJumpEnd && i < nums.length - 1) {
                    jumpCount++;              // 计数：跳了一次
                    currentJumpEnd = maxReach; // 更新下一跳的终点
                }
            }

            return jumpCount;
        }
    }

}
