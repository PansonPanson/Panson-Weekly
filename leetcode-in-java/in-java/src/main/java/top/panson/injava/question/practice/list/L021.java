package top.panson.injava.question.practice.list;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-05-30 18:59
 * @Author: Panson
 */
public class L021 {

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            while(list1 != null && list2 != null) {
                if(list1.val < list2.val) {
                    dummy.next = list1;
                    list1 = list1.next;
                    dummy = dummy.next;
                } else {
                    dummy.next = list2;
                    list2 = list2.next;
                    dummy = dummy.next;

                }
            }
            while(list1 != null) {
                dummy.next = list1;
            }

            while(list2 != null) {
                dummy.next = list2;
            }
            return head.next;
        }
    }
}
