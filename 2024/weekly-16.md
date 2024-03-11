
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [995. K 连续位的最小翻转次数](https://leetcode.cn/problems/minimum-number-of-k-consecutive-bit-flips/description/)
```java

 class Solution01 {
        public int minKBitFlips(int[] nums, int k) {
            // 使用模拟暴力求解
            int n = nums.length;
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(nums[i] == 0) {
                    // 倒数第 k - 1 位为0
                    if(i + k > n) {
                        return -1;
                    }
                    for(int j = i; j < i + k; j++) {
                        nums[j] ^= 1;
                    }
                    count++;
                }
            }
            return count;
        }
    }

    class Solution02 {
        public int minKBitFlips(int[] nums, int k) {
            int n = nums.length;
            int[] diff = new int[n + 1];
            int ans = 0, revCnt = 0;
            for (int i = 0; i < n; ++i) {
                revCnt += diff[i];
                // 若 nums[i]+revCnt 是偶数，则说明当前元素的实际值为 0
                if ((nums[i] + revCnt) % 2 == 0) {
                    if (i + k > n) {
                        return -1;
                    }
                    ++ans;
                    ++revCnt;
                    --diff[i + k];
                }
            }
            return ans;
        }
    }

```



+ [1109. 航班预订统计](https://leetcode.cn/problems/corporate-flight-bookings/description/)
```java
 class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] dif = new int[n + 1];
        for(int[] booking : bookings) {
            int l = booking[0] - 1;
            int r = booking[1] - 1;
            dif[l] += booking[2];
            dif[r + 1] -= booking[2];
        }

        int[] ret = new int[n];
        ret[0] = dif[0];
        for(int i = 1; i < n; i ++) {
            ret[i] = ret[i - 1] + dif[i];
        }
        return ret;
    }
}
```


















