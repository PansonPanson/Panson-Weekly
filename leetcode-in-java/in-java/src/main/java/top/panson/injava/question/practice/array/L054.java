package top.panson.injava.question.practice.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2022-06-04 14:34
 * @Author: Panson
 */
public class L054 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int left =0;
            int right = n - 1;
            int upper = 0;
            int lower = m - 1;
            List<Integer> res = new ArrayList<>();
            int size = m * n;
            while(res.size() < size) {
                if(upper <= lower) {
                    for(int i = left; i <= right; i++) {
                        res.add(matrix[upper][i]);
                    }
                    upper++;
                }
                if(left <= right) {
                    for(int i = upper; i <= lower; i++) {
                        res.add(matrix[i][right]);
                    }
                    right--;
                }
                if(upper <= lower) {
                    for(int i = right; i >= left; i--) {
                        res.add(matrix[lower][i]);
                    }
                    lower--;
                }
                if(left <= right) {
                    for(int i = lower; i >= upper; i--) {
                        res.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return res;
        }
    }
}
