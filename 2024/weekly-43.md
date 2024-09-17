
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章


## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [988. 从叶结点开始的最小字符串](https://leetcode.cn/problems/smallest-string-starting-from-leaf/description/)
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
    String res = null;
    StringBuilder path = new StringBuilder();
    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        // 如果到达叶子节点
        if(root.left == null && root.right == null) {
            path.append((char)('a' + root.val));
            path.reverse();
            String tmp = path.toString();
            if(res == null || res.compareTo(tmp) > 0) {
                res = tmp;
            }
            path.deleteCharAt(0);
            path.reverse();
            return;
        }
        path.append((char)('a' + root.val));
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length() - 1);
    }
} 
```


+ [1022. 从根到叶的二进制数之和](https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/description/)
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
    int res = 0;
    int path = 0;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return res;
    }


    public void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            res += path << 1 | root.val;
            return;
        }
        path = path << 1 | root.val;
        traverse(root.left);
        traverse(root.right);
        path = path >> 1;
    }
} 
```

















