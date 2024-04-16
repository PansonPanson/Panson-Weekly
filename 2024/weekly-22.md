
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

# [237. 删除链表中的节点](https://leetcode.cn/problems/delete-node-in-a-linked-list/description/)

```java
class Solution01 {
        public void deleteNode(ListNode node) {
            ListNode last = node;
            while(node.next != null) {
                node.val = node.next.val;
                last = node;
                node = node.next;
            }
            last.next = null;
        }
    }


class Solution02 {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
}
```






















