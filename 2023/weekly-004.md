
*日拱一卒*

_________________



# 1 Algorithm(算法题)
+ [274. H 指数](https://leetcode.cn/problems/h-index/)
```java
class Solution {
    public int hIndex(int[] citations) {
        // 使用计数排序. countMap 下标索引表示引用次数，值表示对应引用次数的文章数
        // 引用次数超过 citations.length，也视作 citations.length
        int length = citations.length;
        int[] countMap = new int[length + 1];

        // 30615 -> 010102
        for(int citation : citations) {
            countMap[Math.min(citation, length)]++;
        }

        int sum = 0;
        for(int i = length; i >= 0; i--) {
            // 引用次数大于等于 i 的文章数总和
            // 010102 -> 2 -> 2 -> 3 >= 3 return
            sum += countMap[i];
            if(sum >= i) {
                return i;
            }
        }
        return -1;
    }
}
```



# 2 Technique/Tips(分享一个小技术)

## 2.1 Redis 源码阅读 —— sds 结构体源码阅读

![](https://raw.githubusercontent.com/PansonPanson/blog-pic-2023/main/2023/202311241835437.png)

# 3 Share(分享我的所见所闻)
*本来第 3 部分应该是“分享一个观点”，但我觉得许多时候，人在经常性地分享观点时，会趋于建议或者劝诫，类似“知识陷阱”一样。
这让我对“分享观点”这件事情有些迟疑，基于上述的原因，我将第 4 点改为了“分享我的所见所闻”，内容比较杂乱，包含一周内读过的书、看过的博客、学习的摄影知识等等。*

## 3.1 技术文章
+ [中通快递“双十一”技术战：RocketMQ性能压测揭秘](https://mp.weixin.qq.com/s/ZyJPJdvI7LHh031fMKo7Fw)
+ [得物供应链复杂业务实时数仓建设之路](https://mp.weixin.qq.com/s/4StnjSWpd4rO_GiajmPA6Q)
+ [供应链时效域接口性能进阶之路 ｜ 得物技术](https://mp.weixin.qq.com/s/M3WmLWIcB4maJ_hAiJxZCA)
+ [一个著名的日志系统是怎么设计出来的？](https://mp.weixin.qq.com/s/XiCky-Z8-n4vqItJVHjDIg)
+ [开源 | 携程 Redis On Rocks 实践，节省 2/3 Redis成本](https://mp.weixin.qq.com/s/iSeLZy9wlez07Rv4wT44og)

## 3.2 泛互联网文章
+ [得物供应链：创新引领潮流消费新模式](https://mp.weixin.qq.com/s/Ksw7ItoaPI6Z_5oPWxLfEg)
+ [和 Fenng 的一次聊天](https://mp.weixin.qq.com/s/sMr7VZLE5DsPcxYT4yOzpw)
