package top.panson.injava.question.practice.queueandstack;

import java.util.LinkedList;
import java.util.List;

/**
 * @create 2022-08-15 23:44
 * @Author: Panson
 */
public class L641 {

/**
 * 设计实现双端队列。
 *
 * 实现 MyCircularDeque 类:
 *
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

    /**
     *           4 3 2 3
     * ["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
     * [[3],[1],[2],[3],[4],[],[],[],[4],[]]
     */
    public class MyCircularDeque {

        private List<Integer> values;

        private int last = 0;

        private int capacity = 0;

        public MyCircularDeque(int k) {
            values = new LinkedList<>();
            capacity = k;
        }

        public boolean insertFront(int value) {
            if(last >= capacity) {
                return false;
            }
            values.add(0, value);
            last++;
            return true;
        }

        public boolean insertLast(int value) {
            if(last >= capacity) {
                return false;
            }
            values.add(last, value);
            last++;
            return true;
        }

        public boolean deleteFront() {
            if(last <= 0) {
                return false;
            }
            values.remove(0);
            last--;
            return true;
        }

        public boolean deleteLast() {
            if(last <= 0) {
                return false;
            }
            values.remove(last - 1);
            last--;
            return true;

        }

        public int getFront() {
            if(last <= 0) {
                return -1;
            }
            return values.get(0);
        }

        public int getRear() {
            if(last <= 0) {
                return -1;
            }
            return values.get(last - 1);
        }

        public boolean isEmpty() {
            return last == 0;
        }

        public boolean isFull() {
            return last >= capacity;
        }
    }



/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

}
