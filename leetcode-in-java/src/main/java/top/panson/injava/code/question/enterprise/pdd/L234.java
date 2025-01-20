package top.panson.injava.code.question.enterprise.pdd;

import top.panson.injava.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2025-01-20
 */
public class L234 {

//leetcode submit region begin(Prohibit modification and deletion)
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
        // 快慢指针找到要反转的起始节点
        // 翻转后半部分
        // 遍历对比
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast != null) {
                slow = slow.next;
            }
            ListNode last = reverse(slow);


            while(last != null) {
                if(last.val != head.val) {
                    return false;
                }
                last = last.next;
                head = head.next;
            }
            return true;

        }

        public ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while(cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}
