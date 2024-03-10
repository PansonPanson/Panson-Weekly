package top.panson.injava.question.codetop.bytedance;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-06-12 00:47
 * @Author: Panson
 */
public class L141 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode p1 = new ListNode(-1);
            ListNode p2 = new ListNode(-2);
            p1.next = head;
            p2.next = head;
            while(p2 != null && p2.next != null) {
                if(p1 == p2) {
                    return true;
                }
                p1 = p1.next;
                p2 = p2.next.next;
            }
            return false;
        }
    }
}
