package top.panson.injava.code.question.tags.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2024-09-21
 */
public class L386 {
    class Solution {

        List<Integer> res = new ArrayList<>();
        public List<Integer> lexicalOrder(int n) {
            for(int i = 1; i < 10; i++) {
                traverse(i, n);
            }
            return res;
        }

        public void traverse(int root, int n) {
            if(root > n) {
                return;
            }
            res.add(root);
            for(int i = root * 10; i < root * 10 + 10; i++) {
                traverse(i, n);
            }
        }
    }

}
