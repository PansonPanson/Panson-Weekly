package top.panson.injava.question.practice.list;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-03-23 17:26
 * @Author: Panson
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
            ListNode pre = null;
            ListNode current = head;
            while(current != null) {
                ListNode tmp = current.next;
                current.next = pre;
                pre = current;
                current = tmp;
            }
            return pre;
        }
    }

    class Solution1 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode lastNode = reverseList((head.next));
            head.next.next = head;
            head.next = null;
            return lastNode;
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
    class Solution02 {
        public ListNode reverseList(ListNode head) {
            if(head == null) {
                return head;
            }
            return reverseList(null, head);
        }

        public ListNode reverseList(ListNode pre, ListNode cur) {
            ListNode next = cur.next;
            cur.next = pre;
            if(next == null) {
                return cur;
            }
            return reverseList(cur, next);
        }

    }

}
