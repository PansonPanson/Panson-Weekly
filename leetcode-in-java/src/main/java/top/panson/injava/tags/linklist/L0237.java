package top.panson.injava.tags.linklist;

import top.panson.injava.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-04-16
 */
public class L0237 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution01 {
        public void deleteNode(ListNode node) {
            ListNode last = node;
            while(node.next != null) {
                node.val = node.next.val;
                last = node;
                node = node.next;
            }
            last.next = null;
        }
    }


    class Solution02 {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }



}
