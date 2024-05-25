package top.panson.injava.tags.twopointers.linklist;

import top.panson.injava.question.commondata.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Panson
 * @create 2024-05-23
 */
public class L023 {

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
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
            for(ListNode node : lists) {
                if(node != null) {
                    queue.offer(node);
                }
            }

            ListNode p = new ListNode(-1);
            ListNode dummy = p;
            while(!queue.isEmpty()) {
                ListNode node = queue.poll();
                p.next = node;
                if(node.next != null) {
                    queue.offer(node.next);
                }
                p = p.next;
            }
            return dummy.next;
        }
    }
}
