
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+ [京东零售：后端开发和你聊聊 JVM 如何优化](https://xie.infoq.cn/article/caaaa3070c012a56fbf01fb8d)
+ [京东零售：看完这篇, 你的服务设计能力将再次进化!](https://xie.infoq.cn/article/e696e2ee032d89ea1ee1d576b)
+ [京东零售：动态线程池学习及实践](https://www.infoq.cn/article/QjlXW9yE3uweDJdqgY3a)

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)
+ [1658. 将 x 减到 0 的最小操作数](https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/)
```java
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        // 滑动窗口需要寻找的子数组目标和
        int target = sum - x;

        int left = 0, right = 0;
        // 记录窗口内所有元素和
        int windowSum = 0;
        // 记录目标子数组的最大长度
        int maxLen = Integer.MIN_VALUE;
        // 开始执行滑动窗口框架
        while (right < nums.length) {
            // 扩大窗口
            windowSum += nums[right];
            right++;

            while (windowSum > target && left < right) {
                // 缩小窗口
                windowSum -= nums[left];
                left++;
            }
            // 寻找目标子数组
            if (windowSum == target) {
                maxLen = Math.max(maxLen, right - left);
            }
        }
        // 目标子数组的最大长度可以推导出需要删除的字符数量
        return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;
    }
}
```


+ [713. 乘积小于 K 的子数组](https://leetcode.cn/problems/subarray-product-less-than-k/description/)
```java
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        // 滑动窗口，初始化为乘法单位元
        int windowProduct = 1;
        // 记录符合条件的子数组个数
        int count = 0;

        while (right < nums.length) {
            // 扩大窗口，并更新窗口数据
            windowProduct = windowProduct * nums[right];
            right++;

            while (left < right && windowProduct >= k) {
                // 缩小窗口，并更新窗口数据
                windowProduct = windowProduct / nums[left];
                left++;
            }

            count += right - left;
        }

        return count;
    }
} 
```

+ [1004. 最大连续1的个数 III](https://leetcode.cn/problems/max-consecutive-ones-iii/description/)
```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        // 记录窗口中 1 的出现次数
        int windowOneCount = 0;
        // 记录结果长度
        int res = 0;

        // 开始滑动窗口模板
        while (right < nums.length) {
            // 扩大窗口
            if (nums[right] == 1) {
                windowOneCount++;
            }
            right++;

            while (right - left - windowOneCount > k) {
                // 当窗口中需要替换的 0 的数量大于 k，缩小窗口
                if (nums[left] == 1) {
                    windowOneCount--;
                }
                left++;
            }
            // 此时一定是一个合法的窗口，求最大窗口长度
            res = Math.max(res, right - left);
        }
        return res;
    }
} 
```

+ [219. 存在重复元素 II](https://leetcode.cn/problems/contains-duplicate-ii/description/)
```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Set<Integer> window = new HashSet<>();
        while(right < nums.length) {
            if(right - left <= k && window.contains(nums[right])) {
                return true;
            }
            window.add(nums[right]);
            right++;
            if(right - left > k) {
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
```

+ [424. 替换后的最长重复字符](https://leetcode.cn/problems/longest-repeating-character-replacement/description/)
```java
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        // 统计窗口中每个字符的出现次数
        int[] windowCharCount = new int[26];
        // 记录窗口中字符的最多重复次数
        // 记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符
        // 所以窗口大小减去 windowMaxCount 就是所需的替换次数
        int windowMaxCount = 0;
        // 记录结果长度
        int res = 0;

        // 开始滑动窗口模板
        while (right < s.length()) {
            // 扩大窗口
            windowCharCount[s.charAt(right) - 'A']++;
            windowMaxCount = Math.max(windowMaxCount, windowCharCount[s.charAt(right) - 'A']);
            right++;

            while (right - left - windowMaxCount > k) {
                // 缩小窗口
                windowCharCount[s.charAt(left) - 'A']--;
                left++;
                // 这里不用更新 windowMaxCount
                // 因为只有 windowMaxCount 变得更大的时候才可能获得更长的重复子串，才会更新 res
            }
            // 此时一定是一个合法的窗口
            res = Math.max(res, right - left);
        }
        return res;
    }
}
```

+ [2824. 统计和小于目标的下标对数目](https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/description/)
```java
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        int res = 0;
        while(left < right) {
            int sum = nums.get(left) + nums.get(right);
            if(sum < target) {
                res += right - left;
                left++;
            } else if(sum >= target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
} 
```

























