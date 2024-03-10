package top.panson.injava.question.practice.array;

import java.util.Arrays;

/**
 * @create 2022-08-24 10:15
 * @Author: Panson
 */
public class L1460 {

    class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {
            Arrays.sort(target);
            Arrays.sort(arr);
            for(int i = 0; i < target.length; i++) {
                if(target[i] != arr[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789".length());
    }
}
