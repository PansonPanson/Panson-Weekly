package top.panson.injava.question.practice.array;

/**
 * @create 2022-06-04 14:50
 * @Author: Panson
 */
public class L059 {

    class Solution {
        public int[][] generateMatrix(int n) {
            int upper = 0; int left = 0;
            int lower = n - 1; int right = n - 1;
            int[][] res = new int[n][n];
            int size = 0;
            while(size < n * n) {
                if(upper <= lower) {
                    for(int i = left; i <= right; i++) {
                        res[upper][i] = ++size;
                    }
                    upper++;
                }
                if(left <= right) {
                    for(int j = upper; j <= lower; j++) {
                        res[j][right] = ++size;
                    }
                    right--;
                }
                if(upper <= lower) {
                    for(int i = right; i >= left; i--) {
                        res[lower][i] = ++size;
                    }
                    lower--;
                }
                if(left <= right) {
                    for(int j = lower; j >= upper; j--) {
                        res[j][left] = ++size;
                    }
                    left++;
                }
            }
            return res;
        }
    }
}
