package top.panson.injava.question.top100;

import java.util.Arrays;

/**
 * 下一个排列
 * <p>
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @create 2022-01-14 14:30
 * @Author: Panson
 */
public class L031 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,9,8,7};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    /**
     * 从后往前遍历，直到找到较小数nums[i]（不是升序排序的第一位）；
     * 从（i, length -1] 区间最后一位开始，找出第一个比 nums[i] 大的 nums[j];
     * 交换 nums[i] 和 nums[j];
     * 将（i, length -1] 的数升序（此处可以首尾两两交换）
     * @param nums
     * @return
     */
    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后往前遍历，直到找到较小数nums[i]（不是升序排序的第一位）
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // j 从最后一位开始，找出第一个比 nums[i] 大的
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        return reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     *  @param nums
     * @param start
     * @return
     */
    public static int[] reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        return nums;
    }

//    public void nextPermutation(int[] nums) {
//        if (nums.length == 0) {
//            return;
//        }
//        int len = nums.length;
//        //从后向前遍历
//        for (int i = len - 1; i >= 0; i--) {
//            //如果i为0，说明数组从后到前是递增（654321）的,没有更大的了
//            //直接重排序变成一个递减的（123456）符合题意
//            if (i == 0) {
//                Arrays.sort(nums);
//                return;
//            } else if (nums[i] > nums[i - 1]) {
//                //一旦出现后一个数字nums[i]比前一个大，说明存在更大的整数
//                //对nums[i]及后面的数组排序，从小到大
//                Arrays.sort(nums, i, len);
//                for (int j = i; i < len; j++) {
//                    //由于从i开始后面已经排序
//                    //那么保证获得比nums[i-1]大的数，是[i,...,len-1]中最小的,交换即可
//                    if (nums[j] > nums[i - 1]) {
//                        swap(nums, j, i - 1);
//                        return;
//                    }
//                }
//            }
//        }
//    }
//
//    public void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}


