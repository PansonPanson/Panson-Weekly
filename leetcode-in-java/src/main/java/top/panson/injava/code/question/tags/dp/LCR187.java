package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-16
 */
public class LCR187 {
    class Solution {
        public int iceBreakingGame(int num, int target) {
            int ans = 0;
            for(int i = 2; i <= num; i++) {
                ans = (ans + target) % i;
            }
            return ans;
        }
    }
}
