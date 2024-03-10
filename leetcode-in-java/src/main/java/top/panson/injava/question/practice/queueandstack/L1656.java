package top.panson.injava.question.practice.queueandstack;

/**
 * @create 2022-08-16 14:39
 * @Author: Panson
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个(id, value) 对。
 *
 * 设计一个流，以 任意 顺序获取 n个(id, value)对，并在多次调用时 按 id 递增的顺序 返回一些值。
 *
 * 实现 OrderedStream 类：
 *
 * OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个id + 1。
 * 否则，返回一个空列表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-an-ordered-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1656 {

    class OrderedStream {
        private String[] values;
        private int ptr = 1;

        public OrderedStream(int n) {
            values = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            values[idKey] = value;
            List<String> res = new ArrayList<>();
            for (int i = ptr; i < values.length; i++) {
                if (values[i] == null) {
                    ptr = i;
                    return res;
                } else {
                    res.add(values[i]);
                }
            }
            return res;
        }
    }

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */


/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
}
