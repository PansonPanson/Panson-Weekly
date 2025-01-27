package top.panson.injava.code.question.enterprise.pdd;

import top.panson.injava.code.question.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2025-01-27
 */
public class L148 {

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
        public ListNode sortList(ListNode head) {
            // 终止条件：如果链表为空或只有一个节点，直接返回
            if (head == null || head.next == null) {
                return head;
            }

            // 使用快慢指针找到链表中点
            ListNode mid = getMid(head);

            // 分割链表为两部分
            ListNode left = head;
            ListNode right = mid.next;
            mid.next = null; // 断开链表

            // 递归排序左右两部分
            ListNode sortedLeft = sortList(left);
            ListNode sortedRight = sortList(right);

            // 合并两个有序链表
            return merge(sortedLeft, sortedRight);
        }

        // 使用快慢指针找到链表中点
        private ListNode getMid(ListNode head) {
            ListNode slow = head, fast = head;
            ListNode prev = null;

            // 快指针走两步，慢指针走一步，快指针到尾时慢指针到中点
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            return prev; // 返回中点的前一个节点
        }

        // 合并两个有序链表
        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0); // 哨兵节点
            ListNode current = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }

            // 合并剩余的节点
            current.next = (l1 != null) ? l1 : l2;

            return dummy.next;
        }
    }

}
