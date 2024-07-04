
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+ [京东技术-供应链大屏设计实践](https://mp.weixin.qq.com/s/zRZtl89bVgWRTnK-YmfNcg)

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [204. 计数质数](https://leetcode.cn/problems/count-primes/description/)

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for(int i = 2; i * i < n; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
```

+ [263. 丑数](https://leetcode.cn/problems/ugly-number/)

```java


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 丑数 就是只包含质因数 2、3 和 5 的正整数。
     *
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     *
     * 示例 1：
     *
     * 输入：n = 6
     * 输出：true
     * 解释：6 = 2 × 3
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：true
     * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
     * 示例 3：
     *
     * 输入：n = 14
     * 输出：false
     * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
     * 提示：
     *
     * -231 <= n <= 231 - 1
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        if(n <= 0) {
            return false;
        }

        while(n % 2 == 0) {
            n /= 2;
        }

        while(n % 3 == 0) {
            n /= 3;
        }

        while(n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
```



+ [264. 丑数 II](https://leetcode.cn/problems/ugly-number-ii/description/)

```java
class Solution {
    public int nthUglyNumber(int n) {
        int i = 1;
        int[] ugly = new int[n + 1];
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        int step2 = 1;
        int step3 = 1;
        int step5 = 1;

        while(i <= n) {
            int min = Math.min(Math.min(step2, step3), step5);
            ugly[i] = min;
            i++;
            if(min == step2) {
                step2 =  2 * ugly[p1++];
            }
            if(min == step3) {
                step3 = 3 * ugly[p2++];
            }
            if(min == step5) {
                step5 = 5 * ugly[p3++];
            }
        }
        return ugly[n];
    }
}
```


+ [378. 有序矩阵中第 K 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/description/)
```java
class Solution {
    /**
     * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
     *
     * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
     * 输出：13
     * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
     * 示例 2：
     *
     * 输入：matrix = [[-5]], k = 1
     * 输出：-5
     * 提示：
     *
     * n == matrix.length
     * n == matrix[i].length
     * 1 <= n <= 300
     * -109 <= matrix[i][j] <= 109
     * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
     * 1 <= k <= n2
     * 进阶：
     *
     * 你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题?
     * 你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            q.offer(new int[] {matrix[i][0], i, 0});
        }

        int res = 0;
        while(!q.isEmpty() && k > 0) {
            int[] cur = q.poll();
            int i = cur[1];
            int j = cur[2];
            k--;
            res = cur[0];
            if(j + 1 < n) {
                q.offer(new int[]{matrix[i][j + 1], i, j + 1});
            }
        }
        return res;
    }
}
```


+ [3115. 质数的最大距离](https://leetcode.cn/problems/maximum-prime-difference/description/)
```java

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int p1 = -1; // 初始化第一个质数的下标
        int p2 = -1; // 初始化最后一个质数的下标
        for(int i = 0; i < nums.length; i++) {
            if(isPrime(nums[i])) {
                if(p1 == -1) {
                    p1 = i;
                }
                p2 = i;
            }
        }
        return p2 - p1;
    }

    public boolean isPrime(int num) {
        if (num < 2) return false; // 小于2的数不是质数
        // num 题设限制大于 0
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

```


+ [373. 查找和最小的 K 对数字](https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/description/)
```java
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[0] + a[1] - b[0] - b[1];
        });

        for(int i = 0; i < nums1.length; i++) {
            q.offer(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty() && k > 0) {
            int[] cur = q.poll();
            res.add(Arrays.asList(cur[0], cur[1]));
            if(cur[2] + 1 < nums2.length) {
                q.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
            k--;
        }
        return res;

    }
}
```


+ [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/description/)
```java

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

```


+ [92. 反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii/description/)
```java

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     * 示例 2：
     *
     * 输入：head = [5], left = 1, right = 1
     * 输出：[5]
     * 提示：
     *
     * 链表中节点数目为 n
     * 1 <= n <= 500
     * -500 <= Node.val <= 500
     * 1 <= left <= right <= n
     * 进阶： 你可以使用一趟扫描完成反转吗？
     * @param head
     * @param left
     * @param right
     * @return
     */



    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null; // 后驱节点
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    // 1 2 3, n = 2 -> 2 1 3
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
```

+ [234. 回文链表](https://leetcode.cn/problems/palindrome-linked-list/description/)
```java

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 快慢指针找到要反转的起始节点
    // 翻转后半部分
    // 遍历对比
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        ListNode last = reverse(slow);


        while(last != null) {
            if(last.val != head.val) {
                return false;
            }
            last = last.next;
            head = head.next;
        }
        return true;

    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

```


+ [25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/description/)
```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return head;
        }

        ListNode a = head;
        ListNode b = head;

        // 12345
        for(int i = 0; i < k; i++) {
            if(b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;

        while(cur != b) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}

```


+ [88. 合并两个有序数组](https://leetcode.cn/problems/merge-sorted-array/description/)
```java


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;
        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                nums1[i--] = nums2[p2--];
            }
        }

        while (p2 >= 0) {
            nums1[i--] = nums2[p2--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

````
























