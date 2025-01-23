package top.panson.injava.code.question.tags.presum;

/**
 * @author Panson
 * @create 2024-07-22
 */
public class L238 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] pre = new int[n];
            pre[0] = 1;
            int[] post = new int[n];
            post[n - 1] = 1;

            int[] res = new int[n];
            // 维护一个前缀积 和 后缀积
            for(int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] * nums[i - 1];
            }

            for(int i = n - 2; i >= 0; i--) {
                post[i] = post[i + 1] * nums[i + 1];
            }

            res[0] = post[0];
            res[n - 1] = pre[n - 1];
            for(int i = 1; i < n - 1; i++) {
                res[i] = pre[i] * post[i];
            }
            return res;

        }
    }
}
