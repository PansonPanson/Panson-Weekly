
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

+ [47. 全排列 II](https://leetcode.cn/problems/permutations-ii/description/)
```java

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * 示例 2：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 提示：
     *
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     *
     * @param nums
     * @return
     */
    // 1 1 1 2
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }


    public void backtrack(int[] nums) {
        if(track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 

```



+ [39. 组合总和](https://leetcode.cn/problems/combination-sum/description/)

```java
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target);
        return res;
    }

    public void backtrack(int[] candidates, int start, int target) {
        if(sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        if(sum > target) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, i, target);
            sum -= candidates[i];
            track.removeLast();
        }
    }
}
```

+ [111. 二叉树的最小深度](https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/)
```java
class Solution {


    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) {
                    return depth;
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }


} 
```






















