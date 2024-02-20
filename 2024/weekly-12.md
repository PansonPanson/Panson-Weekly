
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+ 

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/description/)
```java
class Solution {
    public boolean isValid(String s) {
        // 如果长度不能被 2 整除，则必定无效
        int n = s.length();
        if(n % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 当前元素是右括号，如果栈顶元素不是左括号，那么 return false
            if(map.containsKey(ch)) {
                if(stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
} 
```

+ [83. 删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/)
```java
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
```


+ [面试题 01.03. URL化](https://leetcode.cn/problems/string-to-url-lcci/description/)
```java
class Solution {
     public String replaceSpaces(String S, int length) {
        
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - index - 1);
    }


}
```

+ [71. 简化路径](https://leetcode.cn/problems/simplify-path/description/)
```java
class Solution {
    public String simplifyPath(String path) {
        // 使用 "/" 分割路径字符串，得到各个组件
        String[] components = path.split("/");
        // 使用栈来辅助简化路径
        Deque<String> stack = new ArrayDeque<>();
        // 遍历路径的各个组件
        for (String component : components) {
            // 如果是 ".."，表示向上一级目录，从栈中弹出元素
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                // 如果不为空且不是 "."，表示有效目录名，推入栈中
                stack.push(component);
            }
        }

        // 构建简化后的路径
        StringBuilder simplifiedPath = new StringBuilder("/");
        for (String component : stack) {
            simplifiedPath.append(component).append("/");
        }

        // 如果路径长度大于1，移除末尾的 "/"
        if (simplifiedPath.length() > 1) {
            simplifiedPath.setLength(simplifiedPath.length() - 1);
        }

        // 返回简化后的路径字符串
        return simplifiedPath.toString();
    }
}
```
















