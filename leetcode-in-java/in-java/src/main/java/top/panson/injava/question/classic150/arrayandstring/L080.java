package top.panson.injava.question.classic150.arrayandstring;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 *
 *
 * 80. 删除有序数组中的重复项 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 说明：
 *
 * 为什么返回数值是整数，但输出的答案是数组呢？
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 * @author Panson
 * @create 2023-10-13
 */
public class L080 {


    public static class Solution {

        /**
         * 为了让解法更具有一般性，我们将原问题的「保留 2 位」修改为「保留 k 位」。
         *
         * 对于此类问题，我们应该进行如下考虑：
         *
         * 由于是保留 k 个相同数字，对于前 k 个数字，我们可以直接保留
         * 对于后面的任意数字，能够保留的前提是：与当前写入的位置前面的第 k 个元素进行比较，不相同则保留
         * 举个🌰，我们令 k=2，假设有如下样例
         *
         * [1,1,1,1,1,1,2,2,2,2,2,2,3]
         *
         * 首先我们先让前 2 位直接保留，得到 1,1
         * 对后面的每一位进行继续遍历，能够保留的前提是与当前位置的前面 k 个元素不同（答案中的第一个 1），因此我们会跳过剩余的 1，将第一个 2 追加，得到 1,1,2
         * 继续这个过程，这时候是和答案中的第 2 个 1 进行对比，因此可以得到 1,1,2,2
         * 这时候和答案中的第 1 个 2 比较，只有与其不同的元素能追加到答案，因此剩余的 2 被跳过，3 被追加到答案：1,1,2,2,3
         *   class Solution {
         *     public int removeDuplicates(int[] nums) {
         *         return process(nums, 2);
         *     }
         *     int process(int[] nums, int k) {
         *         int u = 0;
         *         for (int x : nums) {
         *             if (u < k || nums[u - k] != x) {
         *                 nums[u++] = x;
         *             }
         *         }
         *         return u;
         *     }
         * }
         *
         * 作者：宫水三叶
         * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * 作者：宫水三叶
         * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @param nums
         * @return
         */
        public static int removeDuplicates(int[] nums) {
            return process(nums, 2);
        }

        /**
         * 通用方法
         *
         * @param nums
         * @param k
         * @return
         */
        static int process(int[] nums, int k) {
//            int index = 0;
//            for (int iteratorNum : nums) {
//                // index < k ：前两位数，直接保留
//                // nums[index - k] != iteratorNum : 遍历元素与当前写入位置前面第 k 个元素不同，因为如果相同的话说明遍历元素是重复的
//                if (index < k || nums[index - k] != iteratorNum) {
//                    nums[index++] = iteratorNum;
//                }
//            }
//            return index;
            if(nums.length <= 2) {
                return nums.length;
            }
            int p1 = 2, p2 = 2;
            while(p2 < nums.length) {
                if(nums[p2] != nums[p1 -2]) {
                    nums[p1++] = nums[p2];
                }
                p2++;
            }
            return p1;
        }

//        class Solution {
//            public int removeDuplicates(int[] nums) {
//                if (nums.length < 3) {
//                    return nums.length;
//                }
//                int p1 = 2, p2 = 2;
//                while (p2 < nums.length) {
//                    if (nums[p2] != nums[p1 - 2]) {
//                        nums[p1++] = nums[p2];
//                    }
//                    p2++;
//                }
//                return p1;
//            }
//        }

        public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
//            int[] nums = {1,1,1,2,2,3};
            int i = Solution.removeDuplicates(nums);
            System.out.println(i);
            System.out.println(JSON.toJSONString(nums));
        }

//        public static int removeDuplicates(int[] nums) {
//            if(nums.length <= 2) {
//                return nums.length;
//            }
//            int p1 = -1;
//            int p2 = 1;
//            int count = 1;
//            // 1,1,1,2,2,3 -> 1,1,2,2,3
//            // 1,1,2,2,2,3
//
//            // [0,0,1,1,1,1,2,3,3] -> [0,0,1,1,2,3,3]
//            // 双指针, p1 指向已经处理完的最后一个元素，p2 指向需要处理的第一个元素
//            // 如果是重复的元素，则指针2后移，指针1不动；
//            // 如果不是重复元素，则指针1 后移两位，且将每一位都赋值为指针2的前一位的值
//            while(p2 < nums.length) {
//                if(p2 == nums.length - 1) {
//                    if (nums[p2] == nums[p2 - 1]) {
//                        count = 2;
//                    }
//                    while(count > 0) {
//                        p1++;
//                        nums[p1] = nums[p2];
//                        count--;
//                    }
//                    p2++;
//                } else {
//                    // 说明重复
////                int cur = nums[p2 - 1];
//                    if (nums[p2] == nums[p2 - 1]) {
//                        count++;
//                        p2++;
//                    } else {
//                        // 说明连续重复的元素大于2
//                        if (count > 2) {
//                            p1++;
//                            nums[p1] = nums[p2 - 1];
//                            p1++;
//                            nums[p1] = nums[p2 - 1];
//                        } else {
//                            // 说明连续重复的元素为1或2，
//                            while (count > 0) {
//                                p1++;
//                                nums[p1] = nums[p2 - 1];
//                                count--;
//                            }
//                        }
//                        p2++;
//                        count = 1;
//                    }
//                }
//            }
//            return p1 + 1;
//        }

//    }

    }



}
