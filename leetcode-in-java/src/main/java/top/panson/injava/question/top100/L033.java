package top.panson.injava.question.top100;

/**
 * 33. 搜索旋转排序数组
 * @create 2022-01-15 16:24
 * @Author: Panson
 */
public class L033 {
    // 4567123, 5
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) {
            return -1;
        }
        if(length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int l = 0, r = length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            // 0 到 mid 是（不严格）递增的
            if(nums[0] <= nums[mid]) {
                // target 在递增区间
                if(nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // mid 到 length - 1 是递增的
                // target 在递增区间
                if(nums[mid] < target && target <= nums[length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
