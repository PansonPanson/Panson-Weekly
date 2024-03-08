package top.panson.injava.question.top100;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-01-20 15:15
 * @Author: Panson
 */
public class L206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
