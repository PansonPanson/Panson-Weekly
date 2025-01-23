package top.panson.injava.code.question.enterprise.pdd;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-01-21
 */
public class L235 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> pathP = getPath(root, p);
            List<TreeNode> pathQ = getPath(root, q);
            TreeNode ancestor = null;
            for(int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
                if(pathP.get(i) == pathQ.get(i)) {
                    ancestor = pathP.get(i);
                } else {
                    break;
                }
            }
            return ancestor;

        }


        public List<TreeNode> getPath(TreeNode root, TreeNode target) {
            List<TreeNode> path = new ArrayList<>();
            TreeNode node = root;
            while(node != target) {
                path.add(node);
                if(target.val < node.val) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            path.add(node);
            return path;
        }
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ancestor = root;
            while(true) {
                if(p.val < ancestor.val && q.val < ancestor.val) {
                    ancestor = ancestor.left;
                } else if(p.val > ancestor.val && q.val > ancestor.val) {
                    ancestor = ancestor.right;
                } else {
                    break;
                }
            }
            return ancestor;
        }
    }
}
