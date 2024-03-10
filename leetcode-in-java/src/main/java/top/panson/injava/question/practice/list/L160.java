package top.panson.injava.question.practice.list;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-03-23 17:01
 * @Author: Panson
 */
public class L160 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA;
            ListNode p2 = headB;
            while(p1 != p2) {
                if(p1 != null) {
                    p1 = p1.next;
                } else {
                    p1 = headB;
                }
                if(p2 != null) {
                    p2 = p2.next;
                } else {
                    p2 = headA;
                }
            }
            return p1;
        }
    }
}
