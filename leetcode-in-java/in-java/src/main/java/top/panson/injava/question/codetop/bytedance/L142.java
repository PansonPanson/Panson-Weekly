package top.panson.injava.question.codetop.bytedance;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-06-12 01:25
 * @Author: Panson
 */
public class L142 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // 第一次相遇，快指针多走了 nr，即慢指针走的总步数是环周长的整数倍，
            // 此时再走一段链表起点到环入口的距离，就走到了环入口。
            ListNode p1 = head;
            ListNode p2 = head;
            while(p2 != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
                if(p1 == p2) {
                    break;
                }
            }
            if(p2 == null || p2.next == null) {
                return null;
            }
            p1 = head;
            while(p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2;

        }
    }
}
