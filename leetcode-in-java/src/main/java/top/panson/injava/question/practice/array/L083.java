package top.panson.injava.question.practice.array;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-06-03 13:23
 * @Author: Panson
 */
public class L083 {

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
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            // 11233
            while(fast != null) {
                if(slow.val != fast.val) {
                    slow.next = fast;
                    slow = slow.next;
                }
                fast = fast.next;
            }
            slow.next = null;
            return head;
        }
    }
}
