
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






















