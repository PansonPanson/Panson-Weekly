package top.panson.injava.question.top100;


/**
 * @create 2022-01-14 00:03
 * @Author: Panson
 */
public class L019 {
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    class Solution {
        /**
         * 核心思路在于双指针，并且构建虚节点，方便遍历
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode headNew = new ListNode(0);
            headNew.next = head;
            ListNode pre = headNew, end = headNew;
            while(n > 0) {
                pre = pre.next;
                n--;
            }
            while(pre.next != null) {
                pre = pre.next;
                end = end.next;
            }
            end.next = end.next.next;
            return headNew.next;
        }
    }
}
