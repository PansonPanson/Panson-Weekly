package top.panson.injava.question.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2022-01-19 15:32
 * @Author: Panson
 */
public class L128 {
    static class Solution {

        public static void main(String[] args) {
            int[] nums = new int[]{100,4,200,1,3,2};
            int i = longestConsecutive(nums);
            System.out.println(i);
        }
        public static int longestConsecutive(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }

            int longestLength = 0;

            for (int num : numSet) {
                if (!numSet.contains(num - 1)) {
                    int currentNum = num;
                    // 从 currentNum 开始计数，因为走到这里说明 currentNum 是序列的第一个数
                    int currentLength = 1;

                    while (numSet.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentLength += 1;
                    }

                    longestLength = Math.max(longestLength, currentLength);
                }
            }

            return longestLength;
        }
    }

}
