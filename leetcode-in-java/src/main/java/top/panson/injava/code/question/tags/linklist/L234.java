package top.panson.injava.code.question.tags.linklist;

import top.panson.injava.code.question.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2025-05-07
 */
public class L234 {

    class Solution {
        public boolean isPalindrome(ListNode head) {
            //  1221
            //  12321
            // 快慢指针，翻转慢指针之后的节点。然后快指针从头开始遍历，如果遍历到末尾都相等，则是回文链表
            ListNode slow = new ListNode(-1, head);
            ListNode fast = new ListNode(-1, head);
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            slow.next = reverse(slow.next);
            fast = head;
            slow = slow.next;
            while(slow != null) {
                if(slow.val != fast.val) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }

        public ListNode reverse(ListNode head) {
            ListNode pre = null;
            while(head != null) {

                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;

        }
    }
}
