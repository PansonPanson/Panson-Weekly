package top.panson.injava.code.question.tags.math;

/**
 * @author Panson
 * @create 2024-08-03
 */
public class L372 {
    class Solution {
        int MOD = 1337;
        public int superPow(int a, int[] b) {
            return dfs(a, b, b.length - 1);
        }
        int dfs(int a, int[] b, int u) {
            if (u == -1) {
                return 1;
            }
            return qpow(dfs(a, b, u - 1), 10) * qpow(a, b[u]) % MOD;
        }
        int qpow(int a, int b) {
            int ans = 1;
            a %= MOD;
            while (b != 0) {
                if ((b & 1) != 0) {
                    ans = ans * a % MOD;
                }
                a = a * a % MOD;
                b >>= 1;
            }
            return ans;
        }
    }

}
