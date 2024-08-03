
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)
+ [384. 打乱数组](https://leetcode.cn/problems/shuffle-an-array/description/)
```java
class Solution {
    int[] nums;
    Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for(int i = 0; i < n; i++) {
            int next = i + random.nextInt(n - i);
            int tmp = copy[i];
            copy[i] = copy[next];
            copy[next] = tmp;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
```

+ [382. 链表随机节点](https://leetcode.cn/problems/linked-list-random-node/description/)
```java
class Solution {
    ListNode head;
    Random random = new Random(20220116);
    public Solution(ListNode _head) {
        head = _head;
    }
    public int getRandom() {
        int i = 0, res = 0;
        ListNode p = head;
        // while 循环遍历链表
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            if (0 == random.nextInt(i)) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
 
```

+ [398. 随机数索引](https://leetcode.cn/problems/random-pick-index/description/)
```java
class Solution {

    Random random;
    Map<Integer, List<Integer>> map;
    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indices = map.get(target);
        return indices.get(random.nextInt(indices.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */ 
```
+ [172. 阶乘后的零](https://leetcode.cn/problems/factorial-trailing-zeroes/description/)
```java
class Solution {
    public int trailingZeroes(int n) {
        if(n < 5) {
            return 0;
        }
        int res = 0;
        while(n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
} 
```


+ [793. 阶乘函数后 K 个零](https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function/description/)
```java

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 主函数 */
    public int preimageSizeFZF(int K) {
        // 左边界和右边界之差 + 1 就是答案
        return (int)(rightBound(K) - leftBound(K) + 1);
    }

    /* 搜索 trailingZeroes(n) == K 的左侧边界 */
    long leftBound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /* 搜索 trailingZeroes(n) == K 的右侧边界 */
    long rightBound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }

    // 逻辑不变，数据类型全部改成 long
    long trailingZeroes(long n) {
        long res = 0;
        while(n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
```

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

+ [372. 超级次方](https://leetcode.cn/problems/super-pow/description/)
```java
 class Solution {
    int MOD = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }
    int dfs(int a, int[] b, int u) {
        if (u == -1) return 1;
        return qpow(dfs(a, b, u - 1), 10) * qpow(a, b[u]) % MOD;
    }
    int qpow(int a, int b) {
        int ans = 1;
        a %= MOD;
        while (b != 0) {
            if ((b & 1) != 0) ans = ans * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }
}
```

























