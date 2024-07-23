
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [238. 除自身以外数组的乘积](https://leetcode.cn/problems/product-of-array-except-self/description/)
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        int[] post = new int[n];
        post[n - 1] = 1;

        int[] res = new int[n];
        // 维护一个前缀积 和 后缀积
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        for(int i = n - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }

        res[0] = post[0];
        res[n - 1] = pre[n - 1];
        for(int i = 1; i < n - 1; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;

    }
}
```


+ [525. 连续数组](https://leetcode.cn/problems/contiguous-array/description/)
```java
class Solution {
    public int findMaxLength(int[] nums) {

        int res = 0;
        int n = nums.length;

        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        Map<Integer, Integer> val2Index = new HashMap<>();

        for(int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
        }
        for(int i = 0; i < preSum.length; i++) {
            if(!val2Index.containsKey(preSum[i])) {
                val2Index.put(preSum[i], i);
            } else {
                res = Math.max(res, i - val2Index.get(preSum[i]));
            }
        }
        return res;
    }
} 
```

+ [1124. 表现良好的最长时间段](https://leetcode.cn/problems/longest-well-performing-interval/description/)
```java
class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        for(int i = 0; i < n; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1;
        }
        int[] preSum = new int[n + 1];
        for(int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + hours[i];
        }

        int res = 0;
        Map<Integer, Integer> val2Index = new HashMap<>();

        for(int i = 0; i < n; i++) {

            if(preSum[i + 1] > 0) {
                res = Math.max(res, i + 1);
            } else {
                if(val2Index.containsKey(preSum[i + 1] - 1)) {
                    res = Math.max(res, i - val2Index.get(preSum[i + 1] - 1));
                }
            }
            if (!val2Index.containsKey(preSum[i + 1])) {
                val2Index.put(preSum[i + 1], i);
            }
        }
        return res;
    }
}
```


+ [523. 连续的子数组和](https://leetcode.cn/problems/continuous-subarray-sum/description/)
```java
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for(int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        System.out.println(Arrays.toString(preSum));
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < preSum.length; i++) {
            int remain = preSum[i] % k;
            if(remain == 0 && i >= 2) {
                return true;
            } else {
                if(map.containsKey(remain) && (i - map.get(remain)) >= 2) {
                    return true;
                }
            }

            map.putIfAbsent(remain, i);

        }
        return false;
    }
} 
```
























