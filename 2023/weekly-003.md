
*日拱一卒*

_________________



# 1 Algorithm(算法题)

+ [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/description/)

```java

class Solution {
    public boolean canJump(int[] nums) {
        
        // 定义 maxDistance，表示遍历当前元素时能跳到的最大距离
        int maxDistance = 0;
        for(int i = 0; i < nums.length; i++) {
            // base case
            if(i > maxDistance) {
                return false;
            }
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }
        return true;
    }
}

```

+ [45. 跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/description/)

```java
class Solution {
    public int jump(int[] nums) {
        // 使用贪心算法
        // 最优跳跃次数
        int times = 0;

        // 当前跳跃次数下的所能到达的右边界
        int border = 0;
        
        // 记录已遍历元素所能跳跃的最远位置的下标
        int maxIndex = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if(i == border) {
                times++;
                // 更新下一轮次跳跃的右边界
                border = maxIndex;
            }
        }
        return times;
    }
}
```



# 2 Technique/Tips(分享一个小技术)

## 2.1 Redis 源码阅读 —— sds 结构体1：为什么 Redis 没有使用 C 语言自带的字符串？

Redis 设计时，考虑到 C 语言字符串的诸多限制，重新设计与实现了字符串。
老生常谈的问题，Redis 为什么要设计专用的字符串，也就是 sds 结构体？
我问了 chatGPT，它给出了以下的回答：
---------

+ **英文：**

Redis does not use the C language's built-in strings primarily because Redis is designed to be a high-performance, in-memory data store that offers advanced data manipulation and storage capabilities. The built-in C strings in the C programming language have limitations that make them unsuitable for Redis' requirements. Here are a few reasons why Redis does not use C's built-in strings:

1. Dynamic resizing: Redis needs to efficiently handle strings of varying lengths, including very large strings. C's built-in strings have a fixed size and cannot dynamically resize themselves, which would limit Redis' ability to handle dynamic data.

2. Memory management: Redis manages memory dynamically and optimizes memory usage. C's built-in strings do not provide automatic memory management or support for efficient memory allocation strategies, which Redis requires to optimize memory usage and prevent memory leaks.

3. Performance considerations: Redis is designed to offer high-performance data storage and manipulation. C's built-in strings have limitations in terms of performance optimizations, such as efficient substring extraction, concatenation, and comparison operations, which could impact Redis' overall performance.

4. Additional data structure requirements: Redis supports various data types, including lists, sets, hashes, and more. C's built-in strings do not provide the necessary abstractions and functionality required to handle these complex data structures efficiently.

5. Compatibility with other languages: Redis is widely used as a data store in various programming languages. By implementing its own string data structure, Redis ensures consistency and compatibility across different language bindings and client libraries.

By designing its own string data structure, Redis can tailor it specifically to meet the performance, memory management, and functionality requirements of a high-performance data store. This allows Redis to offer efficient storage and manipulation of data, making it popular for caching, messaging, and other data-intensive applications.


+ **中文：**

Redis不使用C语言本身的字符串主要是因为Redis被设计为高性能的内存数据存储，提供高级的数据操作和存储功能。C语言的内置字符串具有一些限制，使其不适用于Redis的需求。以下是Redis不使用C语言内置字符串的几个原因：

1. 动态调整大小：Redis需要高效地处理长度可变的字符串，包括非常大的字符串。C语言的内置字符串具有固定的大小，无法动态调整大小，这将限制Redis处理动态数据的能力。

2. 内存管理：Redis动态管理内存并优化内存使用。C语言的内置字符串不提供自动的内存管理或支持高效的内存分配策略，而这是Redis需要的，以优化内存使用并防止内存泄漏。

3. 性能考虑：Redis旨在提供高性能的数据存储和操作。C语言的内置字符串在性能优化方面存在限制，例如高效的子字符串提取、连接和比较操作，这可能会影响Redis的整体性能。

4. 额外的数据结构要求：Redis支持各种数据类型，包括列表、集合、哈希等。C语言的内置字符串不提供处理这些复杂数据结构所需的抽象和功能。

5. 与其他语言的兼容性：Redis被广泛用作各种编程语言中的数据存储。通过实现自己的字符串数据结构，Redis确保不同语言绑定和客户端库之间的一致性和兼容性。

通过设计自己的字符串数据结构，Redis可以根据高性能数据存储的要求进行定制。这使得Redis能够高效地存储和操作数据，因此在缓存、消息传递和其他数据密集型应用中非常受欢迎。


-----------

我个人觉得最主要的是以下 3 个方面：
1. 二进制安全（binary safe）： 所谓“二进制安全”，简单来说指的是可以存储任意类型的数据。C 语言字符串中，`\0` 表示字符串结尾，如果字符串内容想保存 `\0`这类特殊字符，C 语言自带的字符串显然是无法满足要求的。
2. 高性能：比如说字符串长度的读取、字符串追加、比较、扩缩容等操作，比原生的 C 语言字符串更加高效。
3. 避免缓冲区溢出：C 语言中，在字符串拼接时，如果忘记提前申请分配内存空间，会导致缓冲区溢出。在 Redis 中，字符串拼接会自动检查空间是否足够，不够则扩容，避免缓冲区溢出。




# 3 Share(分享我的所见所闻)
*本来第 3 部分应该是“分享一个观点”，但我觉得许多时候，人在经常性地分享观点时，会趋于建议或者劝诫，类似“知识陷阱”一样。
这让我对“分享观点”这件事情有些迟疑，基于上述的原因，我将第 4 点改为了“分享我的所见所闻”，内容比较杂乱，包含一周内读过的书、看过的博客、学习的摄影知识等等。*

## 3.1 技术文章
+ [极客时间-《Redis 核心技术与实战》-16 | 异步机制：如何避免单线程模型的阻塞？](https://time.geekbang.org/column/article/285000?utm_campaign=geektime_search&utm_content=geektime_search&utm_medium=geektime_search&utm_source=geektime_search&utm_term=geektime_search)

## 3.2 泛互联网文章
+ [张一鸣：为什么BAT挖不走我们的人才？](https://mp.weixin.qq.com/s/jxIYY5UNbDdqm4dwaRR70Q)
