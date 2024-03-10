package top.panson.injava.question.enterprise.bytedance.gjhds;

/**
 *
 * 33. 搜索旋转排序数组
 *
 * @create 2023-05-04 12:43
 * @Author: Panson
 */
public class L033 {
    // 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
    // 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
    class Solution {
        public int search(int[] nums, int target) {
            //
            int notFound = -1;
            int length = nums.length;
            int left = 0;
            int right = length - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if(target == nums[middle]) {
                    return middle;
                }
                if(nums[0] <= nums[middle]) {
                    // 说明左部分是递增的
                    if(nums[0] <= target && target < nums[middle]) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                } else {
                    // 说明右部分是递增的
                    if(nums[middle] < target && target <= nums[right]) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
            }
            return notFound;

        }
    }

}
