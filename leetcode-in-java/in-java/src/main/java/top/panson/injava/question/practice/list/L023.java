package top.panson.injava.question.practice.list;

import top.panson.injava.question.commondata.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @create 2022-03-22 19:16
 * @Author: Panson
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

            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;

            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

            for(ListNode node : lists) {
                if(node != null) {
                    queue.offer(node);
                }
            }

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
