
*日拱一卒*

_________________



# 1 Algorithm(算法题)

1. [121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/)

再次聊聊这道题，看到网上有人整理了股票题目的通用解法。

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        // 第 1 天不持有股票，第 1 天持有股票
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
```


2. [122. 买卖股票的最佳时机 II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/)

**代码：**

```java
class Solution {
    public int maxProfit(int[] prices) {
        // 动态规划状态转移方程
        // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}

```

# 2 Review(一篇英文文章)



# 3 Technique/Tips(分享一个小技术)

## 3.1 Redis 源码阅读 —— 千里之行，始于足下，如何搭建 Redis 7.x 源码阅读环境

### 3.1.1 源码下载

直接从 GitHub 源码仓库下载：
```git
git clone https://github.com/redis/redis.git
```

我们以最新的 tag 上去:

```git
git checkout tags/7.0.4 -b 7.0.4
```

### 3.1.2 编译
首先确保安装了 GCC，我本地已安装。
编译：
```c
make CFLAGS="-g -O0" 
```

备注：`-O0` 参数旨在强制编译器不要进行编译优化，避免 debug 的时候源码与实际运行代码不匹配


### 3.1.3 启动

拥抱 jetbrains 全家桶，使用 CLion 2023.2.2 编译好的  Redis 源码。

启动配置如下：
![](![](https://raw.githubusercontent.com/PansonPanson/blog-pic-2023/main/2023/20231103172438.png)




# 4 Share(分享我的所见所闻)
*本来第 4 部分应该是“分享一个观点”，但我觉得许多时候，人在经常性地分享观点时，会趋于建议或者劝诫，类似“知识陷阱”一样。
这让我对“分享观点”这件事情有些迟疑，基于上述的原因，我将第 4 点改为了“分享我的所见所闻”，内容比较杂乱，包含一周内读过的书、看过的博客、学习的摄影知识等等。*

## 4.1 技术博客
+ [虚拟线程原理及性能分析｜得物技术](https://mp.weixin.qq.com/s/vdLXhZdWyxc6K-D3Aj03LA)
+ [Redis成本优化-版本升级-1.SDS优化历史](https://mp.weixin.qq.com/s/BMgOyaC53i_QR9iFwlLUww)
+ [客服发送一条消息背后的技术和思考｜得物技术](https://mp.weixin.qq.com/s/2ToAOW4IM6smWV5ljUS-JA)
+ [得物 Redis 设计与实践](https://mp.weixin.qq.com/s/dnlxCXgAxHsfyVNYTDsewA)
+ [浅析Redis大Key](https://mp.weixin.qq.com/s/T_3fHbyv74FEB5KLzV-A0w)
+ [记一次Redis Cluster Pipeline导致的死锁问题](https://mp.weixin.qq.com/s/Jpo2qqe36QdjY5_jOG8bww)
+ [线上问题排查实例分析｜关于网络超时](https://mp.weixin.qq.com/s/v00M_LPdoyhc1w25aT2xyQ)
