package top.panson.injava.question.practice.list;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-03-23 00:11
 * @Author: Panson
 */
public class L019 {

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
        /**
         * 像这种没有虚节点的写法会空指针，因为 n+1 可能溢出
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode p2 = findMatchNode(n + 1, dummy);
            p2.next = p2.next.next;
            // 不要直接返回head, head 可能已经改变
            return dummy.next;
        }


        private ListNode findMatchNode(int k, ListNode dummy) {
            ListNode p1 = dummy;
            ListNode p2 = dummy;

            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }

            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2;
        }
    }
}
