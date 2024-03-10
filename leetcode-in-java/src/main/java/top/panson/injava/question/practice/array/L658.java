package top.panson.injava.question.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2022-08-25 10:54
 * @Author: Panson
 */
public class L658 {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0;
            int right = arr.length - 1;
            while(right - left != k -1) {
                if(x - arr[left] > arr[right] - x) {
                    left++;
                } else {
                    right--;
                }
            }
            List<Integer> res = new ArrayList<>();
            for(int i = left; i <= right; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }

    public class Solution1 {

        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int size = arr.length;
            int left = 0;
            int right = size - k;
            while (left < right) {
                // int mid = left + (right - left) / 2;
                int mid = (left + right) / 2;
                // 尝试从长度为 k + 1 的连续子区间删除一个元素
                // 从而定位左区间端点的边界值
                if (x - arr[mid] > arr[mid + k] - x) {
                    // 下一轮搜索区间是 [mid + 1..right]
                    left = mid + 1;
                } else {
                    // 下一轮搜索区间是 [left..mid]
                    right = mid;
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = left; i < left + k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }

}
