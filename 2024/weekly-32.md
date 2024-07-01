
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [204. 计数质数](https://leetcode.cn/problems/count-primes/description/)

```java
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
```

+ [263. 丑数](https://leetcode.cn/problems/ugly-number/)

```java


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 丑数 就是只包含质因数 2、3 和 5 的正整数。
     *
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     *
     * 示例 1：
     *
     * 输入：n = 6
     * 输出：true
     * 解释：6 = 2 × 3
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：true
     * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
     * 示例 3：
     *
     * 输入：n = 14
     * 输出：false
     * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
     * 提示：
     *
     * -231 <= n <= 231 - 1
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        if(n <= 0) {
            return false;
        }

        while(n % 2 == 0) {
            n /= 2;
        }

        while(n % 3 == 0) {
            n /= 3;
        }

        while(n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
```























