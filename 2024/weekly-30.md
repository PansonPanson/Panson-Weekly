
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)
+ [78. 子集](https://leetcode.cn/problems/subsets/description/)

```java
class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0);
            return res;
        }

        public void backtrack(int[] nums, int start) {
            res.add(new LinkedList<>(track));

            for(int i = start; i < nums.length; i++) {
                track.add(nums[i]);
                backtrack(nums, i + 1);
                track.removeLast();
            }
        }
    }
```


+ [77. 组合](https://leetcode.cn/problems/combinations/description/)
```java
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k);
        return res;
    }

    public void backtrack(int n, int start, int k) {
        if(k == track.size()) {
            res.add(new LinkedList<>(track));
        }

        for(int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, i + 1, k);
            track.removeLast();
        }
    }
}
```

+ [90. 子集 II](https://leetcode.cn/problems/subsets-ii/description/)
```java
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
```

+ [40. 组合总和 II](https://leetcode.cn/problems/combination-sum-ii/description/)
```java
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    public void backtrack(int[] nums, int start, int target) {
        if(sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if(sum + nums[i] > target) {
                continue;
            }
            track.add(nums[i]);
            sum += nums[i];
            backtrack(nums, i + 1, target);
            sum -= nums[i];
            track.removeLast();
        }
    }
}
```






















