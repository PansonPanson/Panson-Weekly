package top.panson.injava.code.question.tags.bit;

/**
 * @author Panson
 * @create 2025-03-15
 */
public class L191 {

    class Solution {
        public int hammingWeight(int n) {
            int res = 0;
            while(n != 0){
                // n &= (n - 1) ： 消除最后一位 1
                n &= (n - 1);
                res++;
            }
            return res;
        }
    }
}
