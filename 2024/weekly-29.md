
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)
+ [509. 斐波那契数](https://leetcode.cn/problems/fibonacci-number/description/)
```java
class Solution {
    public int fib(int n) {
        if(n < 2) {
            return n;
        }
        int dp0 = 0;
        int dp1 = 1;
        for(int i = 2; i <= n; i++) {
            int tmp = dp0;
            dp0 = dp1;
            dp1 = dp1 + tmp;

        }
        return dp1;
    }
}
```

+ [322. 零钱兑换](https://leetcode.cn/problems/coin-change/description/)
```java
class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dp(coins, amount);
    }
    public int dp(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        if(memo[amount] != -2) {
            return memo[amount];
        }
        for(int coin : coins) {
            int sub = dp(coins, amount - coin);
            if(sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }

        res = res == Integer.MAX_VALUE ? -1 : res;
        memo[amount] = res;
        return res;
    }
}
```

```java
class Solution {

    // dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);

            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}

```






















