package top.panson.injava.code.question.tags.math;

/**
 * @author Panson
 * @create 2024-08-01
 */
public class L793 {
    class Solution {
        /* 主函数 */
        public int preimageSizeFZF(int K) {
            // 左边界和右边界之差 + 1 就是答案
            return (int)(rightBound(K) - leftBound(K) + 1);
        }

        /* 搜索 trailingZeroes(n) == K 的左侧边界 */
        long leftBound(int target) {
            long lo = 0, hi = Long.MAX_VALUE;
            while (lo < hi) {
                long mid = lo + (hi - lo) / 2;
                if (trailingZeroes(mid) < target) {
                    lo = mid + 1;
                } else if (trailingZeroes(mid) > target) {
                    hi = mid;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }

        /* 搜索 trailingZeroes(n) == K 的右侧边界 */
        long rightBound(int target) {
            long lo = 0, hi = Long.MAX_VALUE;
            while (lo < hi) {
                long mid = lo + (hi - lo) / 2;
                if (trailingZeroes(mid) < target) {
                    lo = mid + 1;
                } else if (trailingZeroes(mid) > target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return lo - 1;
        }

        // 逻辑不变，数据类型全部改成 long
        long trailingZeroes(long n) {
            long res = 0;
            while(n > 0) {
                n /= 5;
                res += n;
            }
            return res;
        }
    }
}
