package top.panson.injava.tags.slidingwindow;

/**
 * @author Panson
 * @create 2024-09-01
 */
public class L713 {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int left = 0, right = 0;
            // 滑动窗口，初始化为乘法单位元
            int windowProduct = 1;
            // 记录符合条件的子数组个数
            int count = 0;

            while (right < nums.length) {
                // 扩大窗口，并更新窗口数据
                windowProduct = windowProduct * nums[right];
                right++;

                while (left < right && windowProduct >= k) {
                    // 缩小窗口，并更新窗口数据
                    windowProduct = windowProduct / nums[left];
                    left++;
                }

                count += right - left;
            }

            return count;
        }
    }
}
