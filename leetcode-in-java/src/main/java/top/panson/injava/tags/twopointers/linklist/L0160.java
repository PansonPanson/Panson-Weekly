package top.panson.injava.tags.twopointers.linklist;

import top.panson.injava.deprecated.question.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-05-22
 */
public class L0160 {

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
            if(headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA;
            ListNode pB = headB;


            while(pA !=  pB) {
                if(pA == null) {
                    pA = headB;
                } else {
                    pA = pA.next;
                }
                if(pB == null) {
                    pB = headA;
                } else {
                    pB = pB.next;
                }
            }
            return pA;

        }
    }
}
