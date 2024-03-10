package top.panson.injava.question.top100;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @create 2022-01-14 12:08
 * @Author: Panson
 */
public class L021 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            } else {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }
        head.next = l1 != null ? l1 : l2;
        return res.next;

        //ListNode tempNode = new ListNode(-1, null);
        //        ListNode head = tempNode;
        //        while(l1 != null && l2 != null) {
        //            if(l1.val <= l2.val) {
        //                tempNode.next = new ListNode(l1.val);
        //                tempNode = tempNode.next;
        //                l1 = l1.next;
        //            } else {
        //                tempNode.next = new ListNode(l2.val);
        //                tempNode = tempNode.next;
        //                l2 = l2.next;
        //            }
        //        }
        //        tempNode.next = (l1 != null ? l1 : l2);
        //        return head.next;
    }
}
