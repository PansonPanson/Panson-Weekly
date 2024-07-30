package top.panson.injava.tags.monotonicstack;

import top.panson.injava.tags.commondata.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2024-03-29
 */
public class L1096 {

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

        public int[] nextLargerNodes(ListNode head) {
            ListNode p1 = head;
            int n = getLength(p1);
            int[] res = new int[n];

            ListNode cur = head;
            // 栈顶是最小的元素数组映射，int[0] 为链表元素值，int[1] 为链表下标索引
            Deque<int[]> stack = new ArrayDeque<>();
            int i = 0;
            while(cur != null) {
                while(!stack.isEmpty() && stack.peek()[0] < cur.val) {
                    int[] min = stack.pop();
                    res[min[1]] = cur.val;
                }
                stack.push(new int[]{cur.val, i});
                i++;
                cur = cur.next;
            }
            return res;
        }

        public int getLength(ListNode p) {
            int res = 0;
            while(p != null) {
                p = p.next;
                res++;
            }
            return res;
        }
    }
}
