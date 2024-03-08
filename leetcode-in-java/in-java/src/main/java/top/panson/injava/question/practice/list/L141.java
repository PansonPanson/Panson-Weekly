package top.panson.injava.question.practice.list;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-03-22 19:34
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
            ListNode fast = new ListNode(-1);
            ListNode slow = new ListNode(-2);
            fast.next = head;
            slow.next = head;
            while(fast != null && fast.next != null) {
                if(fast == slow) {
                    return true;
                } else {
                    fast = fast.next.next;
                    slow = slow.next;
                }
            }
            return false;
        }
    }
}
