package top.panson.injava.code.question.tags.linklist.twopointers.linklist;

import top.panson.injava.code.question.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2025-04-28
 */
public class L024 {

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
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(-1, head);
            ListNode p1 = head;
            ListNode p2 = head.next;
            // 1 2 3 4 5
            ListNode pre = dummy;
            while(p1 != null && p2 != null) {
                ListNode p3 = p2.next;
                p2.next = p1;
                p1.next = p3;
                pre.next = p2;

                pre = p1;
                p1 = p1.next;
                p2 = p1 != null ? p1.next : null;
            }
            return dummy.next;
        }
    }


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
    class Solution1 {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }

            // 1 2 3 4 5
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            while(pre.next != null && pre.next.next != null) {
                ListNode p1 = pre.next;
                ListNode p2 = pre.next.next;

                p1.next = p2.next;
                p2.next = p1;
                pre.next = p2;

                pre = p1;

            }
            return dummy.next;
        }
    }
}
