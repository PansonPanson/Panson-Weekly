package top.panson.injava.question.practice.list;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-03-24 23:35
 * @Author: Panson
 */
public class L025 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * 反转区间 [a, b) 的元素，注意是左闭右开
         */
        ListNode reverse(ListNode a, ListNode b) {
            ListNode pre, cur, nxt;
            pre = null;
            cur = a;
            // 通过 pre = null， 让原链表断掉
            while (cur != b) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            // 返回反转后的头结点
            return pre;
        }

        ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;
            // 区间 [a, b) 包含 k 个待反转元素
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                // 不足 k 个，不需要反转，base case
                if (b == null) {
                    return head;
                }
                b = b.next;
            }
            // 反转前 k 个元素
            ListNode newHead = reverse(a, b);
            // 递归反转后续链表并连接起来
            a.next = reverseKGroup(b, k);
            return newHead;
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null) {
                return null;
            }
            ListNode p = head;
            for(int i = 0; i < k; i++) {
                if(p == null) {
                    return head;
                }
                p = p.next;
            }
            ListNode newHead = reverse(head, p);
            head.next =  reverseKGroup(p, k);
            return newHead;
        }

        public ListNode reverse(ListNode head, ListNode tail) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode next;
            while(cur != tail) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
