package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-02-07
 */
public class L152 {
    class Solution {
        public int maxProduct(int[] nums) {
            // 特殊情况处理：数组为空或长度为0
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // 初始化
            int n = nums.length;
            // maxProd 表示以当前元素结尾的子数组的最大乘积
            int maxProd = nums[0];
            // minProd 表示以当前元素结尾的子数组的最小乘积
            int minProd = nums[0];
            // globalMax 保存全局的最大乘积
            int globalMax = nums[0];

            // 从第二个元素开始遍历
            for (int i = 1; i < n; i++) {
                int cur = nums[i];

                // 当当前元素为负数时，maxProd 和 minProd 交换
                // 因为负数乘以最小乘积可能变成最大乘积
                if (cur < 0) {
                    int temp = maxProd;
                    maxProd = minProd;
                    minProd = temp;
                }

                // 更新以当前元素结尾的子数组最大乘积：
                // 当前元素单独作为一个子数组，或者与之前的子数组相乘
                maxProd = Math.max(cur, cur * maxProd);

                // 同理，更新以当前元素结尾的子数组最小乘积
                minProd = Math.min(cur, cur * minProd);

                // 更新全局最大乘积
                globalMax = Math.max(globalMax, maxProd);
            }

            return globalMax;
        }
    }

}
