package top.panson.injava.tags.twopointers.linklist;

import top.panson.injava.question.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-07-03
 */
public class L206 {


//leetcode submit region begin(Prohibit modification and deletion)
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
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
