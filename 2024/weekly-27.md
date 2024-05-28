
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章
+

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)

+ [26. 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int p1= 0; 
        int p2 = 0;
        while(p2 < n) {
            // 找到第一个
            while(p2 < n && nums[p1] == nums[p2]) {
                p2++;
            }
            p1++;
            if(p2 < n) {
                nums[p1] = nums[p2];
            }
        }
        return p1;
    }
}
```






















