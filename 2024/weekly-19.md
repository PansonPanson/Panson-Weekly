
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [496. 下一个更大元素 I](https://leetcode.cn/problems/next-greater-element-i/description/)
```java

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] memory = nextGreaterElement(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], memory[i]);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
```

+ [739. 每日温度](https://leetcode.cn/problems/daily-temperatures/description/)
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}

```

+ [503. 下一个更大元素 II](https://leetcode.cn/problems/next-greater-element-ii/description/)
```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
```

+ [1019. 链表中的下一个更大节点](https://leetcode.cn/problems/next-greater-node-in-linked-list/description/)
```java
 class Solution {

    public int[] nextLargerNodes(ListNode head) {
        ListNode p1 = head;
        int n = getLength(p1);
        int[] res = new int[n];

        ListNode cur = head;
        // 栈顶是最小的元素数组映射，int[0] 为链表元素值，int[1] 为链表下标索引
        Deque<int[]> stack = new ArrayDeque<>();
        int i = 0;
        while(cur != null) {
            while(!stack.isEmpty() && stack.peek()[0] < cur.val) {
                int[] min = stack.pop();
                res[min[1]] = cur.val;
            }
            stack.push(new int[]{cur.val, i});
            i++;
            cur = cur.next;
        }
        return res;
    }

    public int getLength(ListNode p) {
        int res = 0;
        while(p != null) {
            p = p.next;
            res++;
        }
        return res;
    }
}


```


















