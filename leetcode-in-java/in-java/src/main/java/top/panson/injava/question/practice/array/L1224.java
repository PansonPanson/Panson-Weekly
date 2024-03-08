package top.panson.injava.question.practice.array;

import java.util.Arrays;

/**
 * @create 2022-08-19 10:27
 * @Author: Panson
 */
public class L1224 {

    class Solution {
        int[] cnt = new int[100010], sum = new int[100010];
        public int maxEqualFreq(int[] nums) {
            Arrays.fill(cnt, 0); Arrays.fill(sum, 0);
            int n = nums.length, max = 0, ans = 0;
            for (int i = 0; i < n; i++) {
                int t = nums[i], cur = ++cnt[t], len = i + 1;
                sum[cur]++; sum[cur - 1]--;
                max = Math.max(max, cur);
                if (max == 1) ans = len;
                if (max * sum[max] + 1 == len) ans = len;
                if ((max - 1) * (sum[max - 1] + 1) + 1 == len) ans = len;
            }
            return ans;
        }
    }

}
