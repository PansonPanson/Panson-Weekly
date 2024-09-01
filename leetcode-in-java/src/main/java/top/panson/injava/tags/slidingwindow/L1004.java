package top.panson.injava.tags.slidingwindow;

/**
 * @author Panson
 * @create 2024-09-01
 */
public class L1004 {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0, right = 0;
            // 记录窗口中 1 的出现次数
            int windowOneCount = 0;
            // 记录结果长度
            int res = 0;

            // 开始滑动窗口模板
            while (right < nums.length) {
                // 扩大窗口
                if (nums[right] == 1) {
                    windowOneCount++;
                }
                right++;

                while (right - left - windowOneCount > k) {
                    // 当窗口中需要替换的 0 的数量大于 k，缩小窗口
                    if (nums[left] == 1) {
                        windowOneCount--;
                    }
                    left++;
                }
                // 此时一定是一个合法的窗口，求最大窗口长度
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
}
