package top.panson.injava.question.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @create 2022-03-28 00:23
 * @Author: Panson
 */
public class QuickSort {


    class Solution {

        public int[] sortArray(int[] nums) {
            if(nums == null || nums.length == 1) {
                return nums;
            }
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int l, int r) {
            if(l >= r) {
                return;
            }
            int q = patition(nums, l, r);
            quickSort(nums, l, q - 1);
            quickSort(nums, q + 1, r);
        }

        private int patition(int[] nums, int l, int r) {
            int pivot = nums[r];
            int i = l;
            for(int j = l; j < r; j++) {
                if(nums[j] < pivot) {
                    if(i == j) {
                        // 此时无需交换，两者相等
                        i++;
                    } else {
                        swap(nums, i++, j);
                    }
                }

            }
            swap(nums, i, r);
            return i;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    public static class wangzheng {
        // 快速排序，a是数组，n表示数组的大小
        public static void quickSort(int[] nums, int n) {
            quickSortInternally(nums, 0, n-1);
        }

        // 快速排序递归函数，p,r为下标
        private static void quickSortInternally(int[] nums, int p, int r) {
            if (p >= r) return;

            // 获取分区点
            int q = partition(nums, p, r);
            quickSortInternally(nums, p, q-1);
            quickSortInternally(nums, q+1, r);
        }

        private static int partition(int[] nums, int p, int r) {
            int pivot = nums[r];
            int i = p;
            for(int j = p; j < r; ++j) {
                if (nums[j] < pivot) {
                    if (i == j) {
                        ++i;
                    } else {
                        int tmp = nums[i];
                        nums[i++] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }

            int tmp = nums[i];
            nums[i] = nums[r];
            nums[r] = tmp;

            System.out.println("i=" + i);
            return i;
        }
    }

    public static void main(String[] args) {
        int  x = 50;
        Integer[] randomArray = {1, 6 , 20};
        Arrays.sort(randomArray, Collections.reverseOrder());
        List<String> ret = new ArrayList<>();
        for(Integer num : randomArray) {

            int count = x / num;
            if(count > 0) {
                ret.add(count + " 个 " + num);
            }
            int remainder = x % num;
            if(remainder == 0) {
                break;
            }
            x = remainder;

        }
        for(String str : ret) {
            System.out.println(str);
        }
    }
}
