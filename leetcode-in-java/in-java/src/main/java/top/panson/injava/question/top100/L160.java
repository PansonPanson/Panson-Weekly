package top.panson.injava.question.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-01-20 01:21
 * @Author: Panson
 */
public class L160 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            Map<ListNode, Integer> map = new HashMap<>();
            int i = 1;
            while(headA != null) {
                map.put(headA, i);
                i++;
                headA = headA.next;
            }
            while(headB != null) {
                if(map.containsKey(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
            return headB;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA, B = headB;
            while (A != B) {
                A = A != null ? A.next : headB;
                B = B != null ? B.next : headA;
            }
            return A;
        }
        }
}
