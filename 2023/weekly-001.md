
*日拱一卒*

_________________



# 1 Algorithm(一道算法题)

[Leetcode 121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/)

**代码：**

```java
class Solution {
    public int maxProfit(int[] prices) {
        // 核心思路在于计算每日卖出时的利润最大值
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++) {
            // 在遍历到当前元素时， cost 已经是遍历过的元素中的最小值了
            if(prices[i] - cost > profit) {
                profit = prices[i] - cost;
            } 
            cost = Math.min(cost, prices[i]); 
        }
        return profit;
    }
}
```

**核心思路：**

+ 我觉得核心思路是模拟真实买卖股票的流程，以时间为横轴，最大利润为纵轴，假设我在今天卖掉股票，那我的最大收益是多少？
+ 那有卖就有买，想要在今天卖掉股票并获得最大收益，那我是不是得在历史的价格最低点买入，这样我在今日卖出的收益才是最大的。
+ 想通了上述的流程，就可以写出代码了，以 cost 代表历史价格最低点，遍历计算每天的利润最大值时，同时维护最低点买入价格

如果想要再精简一下代码：

```java
class Solution {
    public int maxProfit(int[] prices) {
        // 核心思路在于计算每日卖出时的利润最大值
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++) {
            // 在遍历到当前元素时， cost 已经是遍历过的元素中的最小值了
            profit = Math.max(prices[i] - cost, profit);
            cost = Math.min(cost, prices[i]); 
        }
        return profit;
    }
}
```



# 2 Review(一篇英文文章)

## 2.1 来源

Ted：https://www.ted.com/talks/joao_pedro_de_magalhaes_why_do_animals_have_such_different_lifespans

题目：Why do animals have such different lifespans?

## 2.2 原文

原文（使用 claude.ai 分段）：

For the microscopic lab worm, C. elegans life equates to just a few short weeks on Earth. Compare that with the tortoise, which can age to more than 100 years. Mice and rats reach the end of their lives after just four years, while for the bowhead whale, Earth's longest-lived mammal, death can come after 200.

Like most living things, the vast majority of animals gradually degenerate after reaching sexual maturity in the process known as aging. But what does it really mean to age? The drivers behind this process are varied and complicated, but aging is ultimately caused by cell death and dysfunction.

When we're young, we constantly regenerate cells in order to replace dead and dying ones. But as we age, this process slows down. In addition, older cells don't perform their functions as well as young ones. That makes our bodies go into a decline, which eventually results in disease and death.

But if that's consistently true, why the huge variance in aging patterns and lifespan within the animal kingdom? The answer lies in several factors, including environment and body size. These can place powerful evolutionary pressures on animals to adapt, which in turn makes the aging process different across species.

Consider the cold depths of the Atlantic and Arctic Seas, where Greenland sharks can live to over 400 years, and the Arctic clam known as the quahog can live up to 500. Perhaps the most impressive of these ocean-dwelling ancients is the Antarctic glass sponge, which can survive over 10,000 years in frigid waters. In cold environments like these, heartbeats and metabolic rates slow down. Researchers theorize that this also causes a slowing of the aging process. In this way, the environment shapes longevity.

When it comes to size, it's often, but not always, the case that larger species have a longer lifespan than smaller ones. For instance, an elephant or whale will live much longer than a mouse, rat, or vole, which in turn have years on flies and worms. Some small animals, like worms and flies, are also limited by the mechanics of their cell division. They're mostly made up of cells that can't divide and be replaced when damaged, so their bodies expire more quickly.

And size is a powerful evolutionary driver in animals. Smaller creatures are more prone to predators. A mouse, for instance, can hardly expect to survive more than a year in the wild. So, it has evolved to grow and reproduce more rapidly, like an evolutionary defense mechanism against its shorter lifespan.

Larger animals, by contrast, are better at fending off predators, and so they have the luxury of time to grow to large sizes and reproduce multiple times during their lives. Exceptions to the size rule include bats, birds, moles, and turtles, but in each case, these animals have other adaptations that allow them to escape predators.

But there are still cases where animals with similar defining features, like size and habitat, age at completely different rates. In these cases, genetic differences, like how each organism's cells respond to threats, often account for the discrepancies in longevity.

So it's the combination of all these factors playing out to differing degrees in different animals that explains the variability we see in the animal kingdom.

So what about us? Humans currently have an average life expectancy of 71 years, meaning that we're not even close to being the longest living inhabitants on Earth. But we are very good at increasing our life expectancy. In the early 1900s, humans only lived an average of 50 years. Since then, we've learned to adapt by managing many of the factors that cause deaths, like environmental exposure and nutrition. This, and other increases in life expectancy make us possibly the only species on Earth to take control over our natural fate.



## 2.3 总结

自然界生物寿命具有差异性，从几周到上百年不等，影响生物寿命的主要因素主要包括环境、体型和遗传差异这 3  种。

环境：寒冷环境下,心跳和新陈代谢会放慢，研究人员认为这也会使衰老过程变慢。比如寒冷的大西洋和北极海域，那里的格陵兰鲨鱼可以活过400年，北极蛤蜊甚至可以活到500岁。最令人印象深刻的可能是南极玻璃海绵，它可以在冰冷的海水中存活1万多年。

体型：大型物种的寿命通常比小型物种长，但也有例外。大象和鲸鱼的寿命要比老鼠、鼹鼠或田鼠长的多，后者又比苍蝇和蠕虫长寿。原因可能是小型动物更容易手动掠食者的攻击，为了繁衍，逐渐变得生长迅速并性成熟。

遗传差异：有一些动物，尽管它们有相似的特征如体型和栖息地，但衰老速度完全不同。在这种情况下，遗传差异往往解释了长寿的差异，例如每个生物体细胞响应威胁的方式。

关于人类：人类的平均预期寿命现在是71岁，这意味着我们远未成为地球上最长寿的生物。但我们在延长预期寿命方面非常成功。在20世纪初，人类的平均寿命只有50岁。但是后来我们通过控制环境和增加膳食营养等方式来增加预期寿命。



# 3 Technique/Tips(分享一个小技术)

某内部服务接口，单线程测试时，接口响应时长在 2 秒以内，但使用 jmeter 压测 20 个线程时，响应时长飙升到 27 秒左右。
观察日志发现业务代码中有一条批量插入 的慢 sql。
SQL 语句如下：

```xml
<insert id="batchInsertOrUpdate" parameterType="java.util.List" useGeneratedKeys="true" keyProperty="id">
        insert into 
  			......
        values
        <foreach collection="list" item="item" separator=",">
            (
            ......
            )
        </foreach>
        on duplicate key update last_updated_date = now()
</insert>
```

使用了 `on duplicate key update`，加了排他锁，在并发情况下导致后更新的语句一直在等待先前sql语句的锁释放，从而导致接口性能骤降。

考虑到该表的更新为非核心业务，加了一个异步线程去执行该sql。

参考：https://time.geekbang.org/column/article/80801?utm_campaign=geektime_search&utm_content=geektime_search&utm_medium=geektime_search&utm_source=geektime_search&utm_term=geektime_search

# 4 Share(分享我的所见所闻)

*本来第 4 部分应该是“分享一个观点”，但我觉得许多时候，人在经常性地分享观点时，会趋于建议或者劝诫，类似“知识陷阱”一样。
这让我对“分享观点”这件事情有些迟疑，基于上述的原因，我将第 4 点改为了“分享我的所见所闻”，内容比较杂乱，包含一周内读过的书、看过的博客、学习的摄影知识等等。*

## 4.1 技术博客

+ [得物数据库中间件平台“彩虹桥”演进之路](https://mp.weixin.qq.com/s/ZyMBRJqbDQWYxjqlGAquKQ)
+ [彩虹桥架构演进之路-性能篇｜得物技术](https://mp.weixin.qq.com/s/QxtCyNSvxzvJHxwdJzQKzw)
+ [如何正确使用 Bean Validation 进行数据校验｜得物技术](
