
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/description/)
```java
public class L0141 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}
```



+ [142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/description/)
```java
public class L0142 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            boolean existCycle = false;
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast) {
                    existCycle = true;
                    break;
                }
            }
            if(existCycle) {
                fast = head;
            } else {
                return null;
            }
            while(fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}

```

+ [160. 相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists/description/)
```java
/**
 * @author Panson
 * @create 2024-05-22
 */
public class L0160 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA;
            ListNode pB = headB;


            while(pA !=  pB) {
                if(pA == null) {
                    pA = headB;
                } else {
                    pA = pA.next;
                }
                if(pB == null) {
                    pB = headA;
                } else {
                    pB = pB.next;
                }
            }
            return pA;

        }
    }
}
```


+ [19. 删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/)
```java
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        while(n > 0) {
            cur = cur.next;
            n--;
        }
        while(cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
```

+ [21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/)
```java
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            // -1, -9, 3,
            head = head.next;
        }

        if(list1 != null) {
            head.next = list1;
        }
        if(list2 != null) {
            head.next = list2;
        }

        return dummy.next;

    }
}
```


+ [23. 合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/description/)
```java
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for(ListNode node : lists) {
            if(node != null) {
                queue.offer(node);
            }
        }

        ListNode p = new ListNode(-1);
        ListNode dummy = p;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if(node.next != null) {
                queue.offer(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}

```

+ [86. 分隔链表](https://leetcode.cn/problems/partition-list/description/)
```java
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        dummy1.next = head;
        ListNode dummy2 = new ListNode(-1);
        dummy2.next = head;
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        while(head != null) {
            if(head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head= head.next;
        }
        p2.next = null;
        p1.next = dummy2.next;
        return dummy1.next;
    }

}
```
+ [876. 链表的中间结点](https://leetcode.cn/problems/middle-of-the-linked-list/description/)

```java
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
    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if(p2 == null) {
            return p1;
        } else {
            return p1.next;
        }
    }
}
```

+ [167. 两数之和 II - 输入有序数组](https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/)
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int p1 = 0;
        int p2 = n - 1;
        while(p1 < p2) {
            if(numbers[p1] + numbers[p2] == target) {
                return new int[]{p1 + 1, p2 + 1};
            } else if(numbers[p1] + numbers[p2] < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return new int[]{-1, -1};
    }
} 
```





















