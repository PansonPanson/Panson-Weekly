
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





















