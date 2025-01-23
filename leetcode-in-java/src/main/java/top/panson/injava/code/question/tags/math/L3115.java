package top.panson.injava.code.question.tags.math;

/**
 * @author Panson
 * @create 2024-07-02
 */
public class L3115 {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumPrimeDifference(int[] nums) {
            int p1 = -1; // 初始化第一个质数的下标
            int p2 = -1; // 初始化最后一个质数的下标
            for(int i = 0; i < nums.length; i++) {
                if(isPrime(nums[i])) {
                    if(p1 == -1) {
                        p1 = i;
                    }
                    p2 = i;
                }
            }
            return p2 - p1;
        }

        public boolean isPrime(int num) {
            if (num < 2) return false; // 小于2的数不是质数
            // num 题设限制大于 0
            for(int i = 2; i * i <= num; i++) {
                if(num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
