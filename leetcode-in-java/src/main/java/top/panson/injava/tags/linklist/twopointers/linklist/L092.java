package top.panson.injava.tags.linklist.twopointers.linklist;

import top.panson.injava.tags.commondata.ListNode;

/**
 * @author Panson
 * @create 2024-07-03
 */
public class L092 {

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
        /**
         * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
         *
         * 示例 1：
         *
         *
         * 输入：head = [1,2,3,4,5], left = 2, right = 4
         * 输出：[1,4,3,2,5]
         * 示例 2：
         *
         * 输入：head = [5], left = 1, right = 1
         * 输出：[5]
         * 提示：
         *
         * 链表中节点数目为 n
         * 1 <= n <= 500
         * -500 <= Node.val <= 500
         * 1 <= left <= right <= n
         * 进阶： 你可以使用一趟扫描完成反转吗？
         * @param head
         * @param left
         * @param right
         * @return
         */



        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left == 1) {
                return reverseN(head, right);
            }
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

        ListNode successor = null; // 后驱节点
        // 反转以 head 为起点的 n 个节点，返回新的头结点
        // 1 2 3, n = 2 -> 2 1 3
        public ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                // 记录第 n + 1 个节点
                successor = head.next;
                return head;
            }
            // 以 head.next 为起点，需要反转前 n - 1 个节点
            ListNode last = reverseN(head.next, n - 1);

            head.next.next = head;
            // 让反转之后的 head 节点和后面的节点连起来
            head.next = successor;
            return last;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
