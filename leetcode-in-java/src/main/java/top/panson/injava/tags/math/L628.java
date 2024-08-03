package top.panson.injava.tags.math;

/**
 * @author Panson
 * @create 2024-07-26
 */
public class L628 {
    class Solution {
        public int maximumProduct(int[] nums) {
            // 没有正数，三个最大数
            // 有正有负：一个最大正数两个最小负数
            // 全是正数：三个最大数
            // 所以只需要 5 个数，3 个最大数和两个最小负数
            int max1 = -1001;
            int max2 = -1001;
            int max3 = -1001;
            int min1 = 1001;
            int min2 = 1001;
            for(int num : nums) {
                if(num < min1) {
                    min2 = min1;
                    min1 = num;
                } else if(num < min2){
                    min2 = num;
                }

                if(num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                }else if(num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if(num > max3) {
                    max3 = num;
                }
            }
            return L372.max(min1 * min2 * max1, max1 * max2 * max3);
        }
    }
}
