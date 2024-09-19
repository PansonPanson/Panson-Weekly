
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


+ [1457. 二叉树中的伪回文路径](https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/description/)
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
    int[] count = new int[10];
    public int pseudoPalindromicPaths (TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            // 叶子节点
            count[root.val]++;
            int oddCount = getOddCount(count);
            if(oddCount <= 1) {
                res++;
            }
            count[root.val]--;
        }

        count[root.val]++;
        traverse(root.left);
        traverse(root.right);
        count[root.val]--;
    }

    public int getOddCount(int[] count) {
        int oddCount = 0;
        for(int num : count) {
            if(num % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount;
    }
}
```


+ [404. 左叶子之和](https://leetcode.cn/problems/sum-of-left-leaves/description/)
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
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        traverse(root.left);
        traverse(root.right);

    }
} 
```

+ [623. 在二叉树中增加一行](https://leetcode.cn/problems/add-one-row-to-tree/description/)
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
    int curDepth = 0;
    int nodeVal;
    int nodeDepth;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        nodeVal = val;
        nodeDepth = depth;
        if(depth == 1) {
            TreeNode newNode = new TreeNode(nodeVal, root, null);
            return newNode;
        }
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        curDepth++;
        if(curDepth == nodeDepth - 1) {
            TreeNode newNodeLeft = new TreeNode(nodeVal, root.left, null);
            TreeNode newNodeRight = new TreeNode(nodeVal, null, root.right);
            root.left = newNodeLeft;
            root.right = newNodeRight;
        }
        traverse(root.left);
        traverse(root.right);
        curDepth--;
    }
}
```


+ [971. 翻转二叉树以匹配先序遍历](https://leetcode.cn/problems/flip-binary-tree-to-match-preorder-traversal/description/)
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
    List<Integer> res = new LinkedList<>();
    int i = 0;
    int[] voyage;
    boolean canFlip = true;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        traverse(root);
        if(canFlip) {
            return res;
        } else {
            return Arrays.asList(-1);
        }
    }

    public void traverse(TreeNode root) {
        if(root == null || !canFlip) {
            return;
        }
        if(root.val != voyage[i]) {
            canFlip = false;
            i++;
            return;
        }
        i++;

        if(root.left != null && root.left.val != voyage[i]) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            res.add(root.val);
        }
        traverse(root.left);
        traverse(root.right);

    }
} 
```

+ [993. 二叉树的堂兄弟节点](https://leetcode.cn/problems/cousins-in-binary-tree/description/)
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

    int x,y;
    TreeNode parrentX = null;
    TreeNode parrentY = null;
    int depthX = 0;
    int depthY = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        traverse(root, 0, null);
        if(depthX == depthY && parrentX != parrentY) {
            return true;
        }
        return false;
    }

    public void traverse(TreeNode root, int depth, TreeNode parent) {
        if(root == null) {
            return;
        }

        if(root.val == x) {
            parrentX = parent;
            depthX = depth;
        }

        if(root.val == y) {
            parrentY = parent;
            depthY = depth;
        }

        traverse(root.left, depth + 1, root);
        traverse(root.right, depth + 1, root);

    }
} 
```

















