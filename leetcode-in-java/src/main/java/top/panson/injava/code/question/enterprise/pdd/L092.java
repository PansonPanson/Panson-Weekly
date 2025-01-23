package top.panson.injava.code.question.enterprise.pdd;

import top.panson.injava.code.question.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-12-22
 */
public class L092 {


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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode reversePre = dummy;
            for(int i = 0; i < left - 1; i++) {
                reversePre = reversePre.next;
            }

            ListNode reverseTail = reversePre;
            for(int i = 0; i < right - left + 1; i++) {
                reverseTail = reverseTail.next;
            }

            // 要反转的首节点
            ListNode reverseHead = reversePre.next;
            // 后继结点
            ListNode rightHead = reverseTail.next;

            reversePre.next = null;
            reverseTail.next = null;

            reverse(reverseHead);

            reversePre.next = reverseTail;
            reverseHead.next = rightHead;
            return dummy.next;
        }


        public void reverse(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while(cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
    }
}
