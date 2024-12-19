package top.panson.injava.deprecated.question.enterprise.pdd;

import top.panson.injava.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-12-19
 */
public class L206 {
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
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode pre = null;
            ListNode cur = head;
            ListNode next;
            while(cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
