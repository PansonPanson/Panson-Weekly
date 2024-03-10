
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+[1094. 拼车](https://leetcode.cn/problems/car-pooling/description/)
```java
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001]; // 1001是因为题目给定了时间范围为 [0, 1000]
        // 记录每个时间点上的乘客数量变化
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0]; // 上车点增加乘客数量
            timestamp[trip[2]] -= trip[0]; // 下车点减少乘客数量
        }
        
        // 遍历每个时间点，检查容量是否足够
        int currentCapacity = 0;
        for (int number : timestamp) {
            currentCapacity += number;
            if (currentCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}
```



















