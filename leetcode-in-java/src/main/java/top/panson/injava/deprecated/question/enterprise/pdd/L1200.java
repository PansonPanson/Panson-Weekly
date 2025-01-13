package top.panson.injava.deprecated.question.enterprise.pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Panson
 * @create 2025-01-14
 */
public class L1200 {
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            // 排序
            // 遍历，维护当前最小的元素差和对应元素差的元素对列表
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 1; i < arr.length; i++) {
                if(arr[i] - arr[i - 1] < min) {
                    min = arr[i] - arr[i - 1];
                    res.clear();
                    List<Integer> cur = new ArrayList<>();
                    cur.add(arr[i - 1]);
                    cur.add(arr[i]);
                    res.add(cur);
                } else if(arr[i] - arr[i - 1] > min){
                    // 大于
                    continue;
                } else {
                    // 等于
                    List<Integer> cur = new ArrayList<>();
                    cur.add(arr[i - 1]);
                    cur.add(arr[i]);
                    res.add(cur);
                }
            }
            return res;
        }
    }


    class Solution1 {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            // 排序
            // 遍历，维护当前最小的元素差和对应元素差的元素对列表
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 1; i < arr.length; i++) {
                if(arr[i] - arr[i - 1] > min) {
                    continue;
                } else if(arr[i] - arr[i - 1] < min) {
                    min = arr[i] - arr[i - 1];
                    res.clear();
                }
                List<Integer> cur = new ArrayList<>();
                cur.add(arr[i - 1]);
                cur.add(arr[i]);
                res.add(cur);
            }
            return res;
        }
    }
}
