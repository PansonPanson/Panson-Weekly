package top.panson.injava.question.practice.list;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-03-23 22:15
 * @Author: Panson
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
            ListNode p = dummy;
            ListNode q = head;

            for(int i = 0; i < left - 1; i++) {
                p = p.next;
                q = q.next;
            }

            for(int i = 0; i < right - left; i++) {
                ListNode removed = q.next;
                q.next = removed.next;
                removed.next = p.next;
                p.next = removed;

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
    class Solution2 {

        ListNode post = null;
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left == 1) {
                return reverseN(head, right - left + 1);
            }
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

        public ListNode reverseN(ListNode head, int n) {
            if(n == 1) {
                post = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n - 1);
            head.next.next = head;
            head.next = post;
            return last;
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            int step = right - left;
            for(int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            // // 12345
            // // 13245
            // // 14325
            ListNode next;
            ListNode cur = pre.next;
            while(step-- > 0) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            return dummy.next;
        }
    }
}
