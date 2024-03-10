package top.panson.injava.question.practice.list;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-03-25 01:58
 * @Author: Panson
 */
public class L234 {

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
        public boolean isPalindrome(ListNode head) {
            // 利用双指针找到需要反转的节点，偶数为 n/2，奇数为 1 + n/2
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 奇数
            if(fast != null) {
                slow = slow.next;
            }

            // 反转slow 之后的部分，包括 slow
            ListNode newHead = reverse(slow);
            while(newHead != null) {
                if(newHead.val != head.val) {
                    return false;
                }
                newHead = newHead.next;
                head = head.next;
            }
            return true;
        }

        public ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode current = head;
            ListNode next = head;
            while(current != null) {
                next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }
            return pre;
        }


    }


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
    class Solution1 {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            // [1, 2, 3, 4, 5, 6, 7]
            // [1 2 3 4 5 6]
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast != null) {
                slow = slow.next;
            }
            ListNode newHead = reverse(slow);
            ListNode p = head;
            while(newHead != null) {
                if(newHead.val != p.val) {
                    return false;
                }
                newHead = newHead.next;
                p = p.next;
            }
            return true;
        }


        public ListNode reverse(ListNode slow) {
            if(slow == null) {
                return null;
            }
            ListNode pre = null;
            ListNode cur = slow;
            ListNode next;
            while(cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
