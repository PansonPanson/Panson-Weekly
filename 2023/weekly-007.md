
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+ [《极客时间-Redis技术核心技术与实战》16 ~ 21]

## 1.2 泛互联网文章




# 2 技术总结



# 3 Algorithm(算法题)

+ [135. 分发糖果](https://leetcode.cn/problems/candy/description/)

```java
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        right[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            ret += Math.max(left[i], right[i]);
        }
        return ret;


    }
}

```

+ [42. 接雨水](https://leetcode.cn/problems/trapping-rain-water/description/)

暴力破解法：
```java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0, rightMax = 0;
        int ret = 0;
        for(int i = 0; i < n; i++) {
            leftMax = calculateLeftMax(i, height);
            rightMax = calculateRightMax(i, height);
            ret += Math.min(leftMax, rightMax) - height[i];
        }
        return ret;
    }

    public int calculateLeftMax(int i, int[] height) {
        int leftMax = 0;
        for(int j = i; j >= 0; j--) {
            leftMax = Math.max(leftMax, height[j]);
        }
        return leftMax;
    }

    public int calculateRightMax(int i, int[] height) {
        int rightMax = 0;
        for(int j = i; j < height.length; j++) {
            rightMax = Math.max(rightMax, height[j]);
        }
        return rightMax;
    }
}
```









