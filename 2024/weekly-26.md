
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























