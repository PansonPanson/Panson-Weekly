
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



+ [264. 丑数 II](https://leetcode.cn/problems/ugly-number-ii/description/)

```java
class Solution {
    public int nthUglyNumber(int n) {
        int i = 1;
        int[] ugly = new int[n + 1];
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        int step2 = 1;
        int step3 = 1;
        int step5 = 1;

        while(i <= n) {
            int min = Math.min(Math.min(step2, step3), step5);
            ugly[i] = min;
            i++;
            if(min == step2) {
                step2 =  2 * ugly[p1++];
            }
            if(min == step3) {
                step3 = 3 * ugly[p2++];
            }
            if(min == step5) {
                step5 = 5 * ugly[p3++];
            }
        }
        return ugly[n];
    }
}
```


+ [378. 有序矩阵中第 K 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/description/)
```java
class Solution {
    /**
     * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
     *
     * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
     * 输出：13
     * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
     * 示例 2：
     *
     * 输入：matrix = [[-5]], k = 1
     * 输出：-5
     * 提示：
     *
     * n == matrix.length
     * n == matrix[i].length
     * 1 <= n <= 300
     * -109 <= matrix[i][j] <= 109
     * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
     * 1 <= k <= n2
     * 进阶：
     *
     * 你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题?
     * 你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            q.offer(new int[] {matrix[i][0], i, 0});
        }

        int res = 0;
        while(!q.isEmpty() && k > 0) {
            int[] cur = q.poll();
            int i = cur[1];
            int j = cur[2];
            k--;
            res = cur[0];
            if(j + 1 < n) {
                q.offer(new int[]{matrix[i][j + 1], i, j + 1});
            }
        }
        return res;
    }
}
```























