
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






















