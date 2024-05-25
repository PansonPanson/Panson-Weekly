package top.panson.injava.tags.twopointers.linklist;

import top.panson.injava.question.commondata.ListNode;

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
}
