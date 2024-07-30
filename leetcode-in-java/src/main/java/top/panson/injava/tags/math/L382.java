package top.panson.injava.tags.math;

import top.panson.injava.tags.commondata.ListNode;

import java.util.Random;

/**
 * @author Panson
 * @create 2024-07-30
 */
public class L382 {
    class Solution {
        ListNode head;
        Random random = new Random(20220116);
        public Solution(ListNode _head) {
            head = _head;
        }
        public int getRandom() {
            int i = 0, res = 0;
            ListNode p = head;
            // while 循环遍历链表
            while (p != null) {
                i++;
                // 生成一个 [0, i) 之间的整数
                // 这个整数等于 0 的概率就是 1/i
                if (0 == random.nextInt(i)) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }

}
