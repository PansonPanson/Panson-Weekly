package top.panson.injava.tags.linklist.twopointers.linklist;

import top.panson.injava.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-05-22
 */
public class L016 {


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
}
