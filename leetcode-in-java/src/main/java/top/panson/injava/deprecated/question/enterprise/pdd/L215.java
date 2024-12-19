package top.panson.injava.deprecated.question.enterprise.pdd;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Panson
 * @create 2024-12-18
 */
public class L215 {

    class Solution {
        public  int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            // 快速选择的目标是找到第 k 大元素，转换为第 n - k (从 0 开始)小的元素
            return quickSelect(nums, 0, n - 1, n - k);
        }

        public  int quickSelect(int[] nums, int left, int right, int targetIndex) {
            // 如果左右指针相遇，直接返回该元素
            if (left == right) {
                return nums[left];
            }

            // 随机选择一个轴心元素并将其放到正确的位置
            Random random = new Random();
            int pivotIndex = left + random.nextInt(right - left + 1);
            pivotIndex = partition(nums, left, right, pivotIndex);

            // 如果轴心元素正好是目标索引，返回对应的值
            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                // 在右侧子数组继续查找
                return quickSelect(nums, pivotIndex + 1, right, targetIndex);
            } else {
                // 在左侧子数组继续查找
                return quickSelect(nums, left, pivotIndex - 1, targetIndex);
            }
        }

        public  int partition(int[] nums, int left, int right, int pivotIndex) {
            // 取出轴心元素
            int pivotValue = nums[pivotIndex];
            // 将轴心元素移动到右边
            swap(nums, pivotIndex, right);
            int storeIndex = left;

            // 遍历数组，将小于轴心的元素移动到左边
            for (int i = left; i < right; i++) {
                if (nums[i] < pivotValue) {
                    swap(nums, storeIndex, i);
                    storeIndex++;
                }
            }

            // 将轴心元素放回正确位置
            swap(nums, storeIndex, right);
            return storeIndex;
        }

        public  void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
