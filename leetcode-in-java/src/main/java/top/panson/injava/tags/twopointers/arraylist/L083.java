package top.panson.injava.tags.twopointers.arraylist;

/**
 * @author Panson
 * @create 2024-06-04
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
            if(head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode p1 = head;
            ListNode p2 = head.next;
            while(p2 != null) {
                while(p2 != null && p1.val == p2.val) {
                    p2 = p2.next;
                }
                p1.next = p2;
                p1 = p1.next;
            }a
            return dummy.next;
        }
    }
}
