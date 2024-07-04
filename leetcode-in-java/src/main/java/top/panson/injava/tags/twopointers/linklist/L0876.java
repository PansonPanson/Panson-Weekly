package top.panson.injava.tags.twopointers.linklist;

import top.panson.injava.deprecated.question.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-05-23
 */
public class L0876 {
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
}
