package top.panson.injava.code.question.tags.linklist;

import java.util.Random;

/**
 * @author Panson
 * @create 2025-05-13
 */

/**
 * 不使用任何库函数，设计一个 跳表 。
 *
 * 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 *
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
 *
 *
 *
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
 *
 * 了解更多 : https://oi-wiki.org/ds/skiplist/
 *
 * 在本题中，你的设计应该要包含这些函数：
 *
 * bool search(int target) : 返回target是否存在于跳表中。
 * void add(int num): 插入一个元素到跳表。
 * bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 */
public class L1206 {
    class Skiplist {
        // 跳表的最大层数
        int level = 10;

        // 跳表节点定义
        class Node {
            int val;                       // 节点值
            Node[] forward = new Node[level]; // 每一层的 forward 指针

            Node(int _val) {
                val = _val;
            }
        }

        Random random = new Random(); // 用于生成随机层数
        Node head = new Node(-1);     // 跳表的头节点（dummy 节点）

        // 辅助函数：查找目标 t 在每一层的前驱节点，保存到 update[] 中
        void find(int t, Node[] update) {
            Node curr = head;
            for (int i = level - 1; i >= 0; i--) {
                // 当前层向右遍历，找到小于 t 的最大节点
                while (curr.forward[i] != null && curr.forward[i].val < t) {
                    curr = curr.forward[i];
                }
                update[i] = curr;
            }
        }

        // 查找目标值 t 是否存在于跳表中
        public boolean search(int t) {
            Node[] update = new Node[level];
            find(t, update);
            Node candidate = update[0].forward[0];
            return candidate != null && candidate.val == t;
        }

        // 插入元素 t
        public void add(int t) {
            Node[] update = new Node[level];
            // 1️⃣ 查找每层的前驱节点
            find(t, update);
            // 2️⃣ 创建新节点
            Node node = new Node(t);
            // // 3️⃣ 决定要插入多少层
            for (int i = 0; i < level; i++) {
                // 插入新节点标准步骤： update[i] -> node -> 原来的 update[i].forward[i]
                node.forward[i] = update[i].forward[i];
                update[i].forward[i] = node;
                // 使用随机数控制是否晋升到下一层
                if (random.nextInt(2) == 0) break;
            }
        }

        // 删除元素 t，如果存在
        public boolean erase(int t) {
            Node[] update = new Node[level];
            find(t, update);
            Node target = update[0].forward[0];
            if (target == null || target.val != t) return false;

            for (int i = 0; i < level && update[i].forward[i] == target; i++) {
                update[i].forward[i] = update[i].forward[i].forward[i];
            }
            return true;
        }
    }

}
