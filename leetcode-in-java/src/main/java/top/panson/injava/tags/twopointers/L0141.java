package top.panson.injava.tags.twopointers;

import top.panson.injava.question.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-05-21
 */
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
            ListNode fast = head.next;
            while(fast != null && fast.next != null) {
                if(slow == fast) {
                    return true;
                } else {
                    slow = slow.next;
                    fast = fast.next.next;
                }
            }
            return false;
        }
    }
}
