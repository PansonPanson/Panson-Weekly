package top.panson.injava.code.question.tags.math;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2024-07-01
 */
public class L204 {

    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            for(int i = 2; i * i < n; i++) {
                if(isPrime[i]) {
                    for(int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for(int i = 2; i < n; i++) {
                if(isPrime[i]) {
                    count++;
                }
            }
            return count;
        }
    }
}
