
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
























