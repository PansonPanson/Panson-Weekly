package top.panson.injava.code.question.tags.linklist.twopointers.linklist;

import top.panson.injava.code.question.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2025-04-28
 */
public class L019 {
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
            ListNode dummy = new ListNode(-1, head);
            // 12345, n = 2
            ListNode fast = dummy;
            while(n > 0) {
                fast = fast.next;
                n--;
            }
            ListNode slow = dummy;
            while(fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
