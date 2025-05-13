package top.panson.injava.code.question.tags.linklist;

import java.util.Random;

/**
 * @author Panson
 * @create 2025-05-13
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
            find(t, update);
            Node node = new Node(t);
            // 决定要插入多少层
            for (int i = 0; i < level; i++) {
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
