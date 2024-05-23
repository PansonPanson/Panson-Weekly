package top.panson.injava.tags.twopointers;

import top.panson.injava.question.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-05-23
 */
public class L086 {

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
}
