
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章


## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [257. 二叉树的所有路径](https://leetcode.cn/problems/binary-tree-paths/description/)
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


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePaths(root, new StringBuilder(), res);
        return res;
    }

    public void binaryTreePaths(TreeNode root, StringBuilder path, List<String> res) {
        if(root == null) {
            return;
        }
        StringBuilder stb = new StringBuilder(path);
        stb.append(String.valueOf(root.val));
        if(root.left == null && root.right == null) {
            res.add(stb.toString());
        } else {
            stb.append("->");
            binaryTreePaths(root.left, stb, res);
            binaryTreePaths(root.right, stb, res);
        }
    }
} 
```


+ [129. 求根节点到叶节点数字之和](https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/)
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
    public int sumNumbers(TreeNode root) {
        traverse(root, new StringBuilder());
        return res;
    }

    public void traverse(TreeNode root, StringBuilder path) {
        if(root == null) {
            return;
        }
        StringBuilder stb = new StringBuilder(path);
        stb.append(root.val);
        if(root.left == null && root.right == null) {
            res += Integer.parseInt(stb.toString());
        } else {
            if(root.left != null) {
                traverse(root.left, stb);
            }
            if(root.right != null) {
                traverse(root.right, stb);
            }

        }
    }
} 
```






















