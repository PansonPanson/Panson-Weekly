package top.panson.injava.code.question.tags.linklist.twopointers.linklist;

import top.panson.injava.code.question.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-05-21
 */
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
    public class Solution1 {
        public ListNode detectCycle(ListNode head) {
            // x + y + z = x + r
            // 快慢指针第一次相遇，slow = x + y, fast = x + y + nr, 2x + 2y = x + y + nr -> x + y = nr ->  x = nr - y
            //  快慢指针第一次相遇， 然后慢指针回到初始节点，走 x 距离 刚好和 fast 指针再次相遇
            ListNode dummy = new ListNode(-1, head);
            ListNode slow = dummy;
            ListNode fast = dummy;
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if(slow == fast) {
                    break;
                }
            }
            if(fast == null || fast.next == null) {
                return null;
            }
            slow = dummy;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;


        }
    }
}
