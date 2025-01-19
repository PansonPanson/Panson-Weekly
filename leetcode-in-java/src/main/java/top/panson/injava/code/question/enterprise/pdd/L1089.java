package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-19
 */
public class L1089 {

    class Solution {
        public void duplicateZeros(int[] arr) {
            // 先找到最后一个有效元素的索引
            int n = arr.length;
            int validCount = 0;
            int zeroCount = 0;
            // 全部非0，则  validCount = arr.length
            while(validCount + zeroCount < n) {
                if(arr[validCount] == 0) {
                    zeroCount++;
                }
                validCount++;
            }

            // i 为最后一个有效元素的下标
            int i = validCount - 1;
            int j = n - 1;
            // 最后一个为0
            if(validCount + zeroCount > n) {
                arr[j--] = 0;
                i--;
            }

            while(j >= 0) {
                arr[j--] = arr[i];
                if(arr[i] == 0) {
                    arr[j--] = 0;
                }
                i--;
            }
        }
    }
}
