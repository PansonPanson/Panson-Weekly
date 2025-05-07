package top.panson.injava.code.question.tags.linklist;

import top.panson.injava.code.question.tags.commondata.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2025-05-07
 */
public class L445 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> stack1 = new ArrayDeque<>();
            Deque<Integer> stack2 = new ArrayDeque<>();

            while(l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while(l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode newTail = null;
            while(!stack1.isEmpty() && !stack2.isEmpty()) {
                Integer v1 = stack1.pop();
                Integer v2 = stack2.pop();
                int sum = v1 + v2 + carry;
                carry = sum / 10;
                newTail = new ListNode(sum % 10, newTail);


            }
            while(!stack1.isEmpty()) {
                int sum = stack1.pop() + carry;
                carry = sum / 10;
                newTail = new ListNode(sum % 10, newTail);
            }

            while(!stack2.isEmpty()) {
                int sum = stack2.pop() + carry;
                carry = sum / 10;
                newTail = new ListNode(sum % 10, newTail);
            }
            if(carry > 0) {
                newTail = new ListNode(carry, newTail);
            }
            return newTail;

        }
    }
}
