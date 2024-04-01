
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [239. 滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/description/)
```
public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int index = 0;
        for(int i = 0; i < n; i++) {
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            while(!q.isEmpty() && i - q.peekFirst() >= k) {
                q.pollFirst();
            }
            q.offerLast(i);

            if(i >= k - 1) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }

        return res;
    }

```


+ [1438. 绝对差不超过限制的最长连续子数组](https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/)

```java
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int l = 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            while(!max.isEmpty() && nums[max.peekLast()] < nums[i]) {
                max.pollLast();
            }
            while(!min.isEmpty() && nums[min.peekLast()] > nums[i]) {
                min.pollLast();
            }
            max.offerLast(i);
            min.offerLast(i);
            while(Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > limit) {
                l++;
                if(max.peekFirst() < l) {
                    max.pollFirst();
                }
                if(min.peekFirst() < l) {
                    min.pollFirst();
                }
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}
```






















