package top.panson.injava.code.question.tags.binarytree;

/**
 * @author Panson
 * @create 2025-03-30
 */
public class LCR152 {
    class Solution {
        public boolean verifyTreeOrder(int[] postorder) {
            return verifyTreeOrder(postorder, 0, postorder.length - 1);
        }

        boolean verifyTreeOrder(int[] postorder, int start, int end) {
            if(start >= end) {
                return true;
            }
            int root = postorder[end];

            int i = start;
            while(i < end && postorder[i] < root) {
                i++;
            }
            // 右子树起点
            int mid = i;
            for(int j = mid; j < end; j++) {
                if(postorder[j] < root) {
                    return false;
                }
            }

            return verifyTreeOrder(postorder, start, mid - 1) && verifyTreeOrder(postorder, mid, end - 1);



        }
    }
}
