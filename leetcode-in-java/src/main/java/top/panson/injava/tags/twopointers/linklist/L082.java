package top.panson.injava.tags.twopointers.linklist;

import top.panson.injava.deprecated.question.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-06-27
 */
public class L082 {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(-101);
            ListNode p1 = dummy;
            ListNode p2 = head;
            while (p2 != null) {
                if (p2.next != null && p2.val == p2.next.val) {
                    while (p2.next != null && p2.val == p2.next.val) {
                        p2 = p2.next;
                    }
                    p2 = p2.next;
                    if (p2 == null) {
                        p1.next = null;
                    }
                } else {
                    p1.next = p2;
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
            return dummy.next;
        }
    }
}
