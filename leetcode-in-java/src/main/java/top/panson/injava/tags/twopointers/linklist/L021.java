package top.panson.injava.tags.twopointers.linklist;

import top.panson.injava.deprecated.question.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-05-23
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
            ListNode head = new ListNode(-1);
            ListNode dummy = head;
            while(list1 != null && list2 != null) {
                if(list1.val < list2.val) {
                    head.next = list1;
                    list1 = list1.next;
                } else {
                    head.next = list2;
                    list2 = list2.next;
                }
                // -1, -9, 3,
                head = head.next;
            }

            if(list1 != null) {
                head.next = list1;
            }
            if(list2 != null) {
                head.next = list2;
            }

            return dummy.next;


        }
    }
}
