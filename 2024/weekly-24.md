
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)
+ [53. 最大子数组和](https://leetcode.cn/problems/maximum-subarray/description/)
```java
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        int ret = dp[0];

        for(int i = 1; i < dp.length; i++) {
            ret = Math.max(dp[i], ret);
        }
        return ret;
    }
} 
```
























