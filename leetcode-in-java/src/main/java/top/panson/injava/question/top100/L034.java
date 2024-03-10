package top.panson.injava.question.top100;

/**
 * @create 2022-01-15 17:38
 * @Author: Panson
 */
public class L034 {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int leftIdx = binarySearch(nums, target - 1);
            int rightIdx = binarySearch(nums, target) - 1;
            if (leftIdx <= rightIdx && nums[leftIdx] == target) {
                return new int[]{leftIdx, rightIdx};
            }
            return new int[]{-1, -1};
        }

        // 第一个大于 target 的数的下标
        public int binarySearch(int[] nums, int target) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }

//    static class Solution {
//
//        public static void main(String[] args) {
//            int[] nums = new int[] {5,7,7,8,8,10};
//            System.out.println(Arrays.toString(searchRange(nums, 8)));
//        }
//        public static int[] searchRange(int[] nums, int target) {
//            int leftIdx = binarySearch(nums, target, true);
//            int rightIdx = binarySearch(nums, target, false) - 1;
//            if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
//                return new int[]{leftIdx, rightIdx};
//            }
//            return new int[]{-1, -1};
//        }
//    }
//
//    /**
//     *
//     * @param nums
//     * @param target
//     * @param lower  如果 lower 为 true，则查找第一个大于等于target 的下标，否则查找第一个大于 target 的下标。
//     *
//     * @return
//     */
//    public static int binarySearch(int[] nums, int target, boolean lower) {
//        int left = 0, right = nums.length - 1, ans = nums.length;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] > target || (lower && nums[mid] >= target)) {
//                right = mid - 1;
//                ans = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;
//    }

}
