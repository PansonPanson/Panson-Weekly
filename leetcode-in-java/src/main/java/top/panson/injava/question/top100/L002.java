package top.panson.injava.question.top100;

/**
 * 两数相加
 * @create 2022-01-11 22:09
 * @Author: Panson
 */
public class L002 {

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
    class Solution {
        /**
         * 核心思路是在构建链表的时候，计算好每个节点的值，有一个需要注意的地方，当循环结束的时候，
         * 还需要判断一下上一节点是否超过10溢出，如果溢出，则需要再增加一个节点
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode point = head;
            // 商
            int quotient = 0;
            while(l1 != null || l2 != null) {
                int sum = calculateSum(l1, l2, quotient);
                // 余数
                int remainder = sum % 10;
                head.next = new ListNode(remainder);
                quotient = sum / 10;
                head = head.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            // 还需要判断一下上一节点是否超过10溢出，如果溢出，则需要再增加一个节点
            if(quotient > 0) {
                head.next = new ListNode(quotient);
            }
            return point.next;
        }

        public int calculateSum(ListNode l1, ListNode l2, int quotient) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            return l1Val + l2Val + quotient;
        }
    }
}
