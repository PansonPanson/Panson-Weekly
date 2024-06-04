
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [27. 移除元素](https://leetcode.cn/problems/remove-element/description/)
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }

        int p1 = 0;
        int p2 = 0;

        int n = nums.length;
        while(p2 <= n - 1) {
            while(p2 <= n - 1 && nums[p2] == val) {
                p2++;
            }
            if(p2 <= n - 1) {
                nums[p1] = nums[p2];
                p1++;
                p2++;
            }
        }
        return p1;
    }
} 
```


+ [283. 移动零](https://leetcode.cn/problems/move-zeroes/description/)
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int p1 = 0;
        int p2 = 0;
        while(p2 <= n - 1) {
            while(p2 <= n - 1 && nums[p2] == 0) {
                p2++;
            }
            if(p2 <= n - 1) {
                nums[p1] = nums[p2];
                p1++;
                p2++;
            }
        }
        while(p1 <= n - 1) {
            nums[p1++] = 0;
        }
    }
} 
```


+ [344. 反转字符串](https://leetcode.cn/problems/reverse-string/description/)
```java
class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int p1 = 0;
        int p2 = n - 1;
        while(p1 < p2) {
            char tmp = s[p1];
            s[p1] = s[p2];
            s[p2] = tmp;
            p1++;
            p2--;
        }
    }
} 
```

+ [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/description/)
```java
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            String palindrome1 = palindrome(s, i, i);
            String palindrome2 = palindrome(s, i, i + 1);
            res = palindrome1.length() > res.length() ? palindrome1 : res;
            res = palindrome2.length() > res.length() ? palindrome2 : res;

        }
        return res;
    }

    public String palindrome(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
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
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null) {
            while(p2 != null && p1.val == p2.val) {
                p2 = p2.next;
            }
            p1.next = p2;
            p1 = p1.next;
        }a
        return dummy.next;
    }
}
```

+ [104. 二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
} 
```

+[144. 二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/description/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}
```





















