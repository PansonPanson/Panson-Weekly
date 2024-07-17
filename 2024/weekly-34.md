
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)
+ [303. 区域和检索 - 数组不可变](https://leetcode.cn/problems/range-sum-query-immutable/description/)
```java
class NumArray {

    int[] numsMemory;

    public NumArray(int[] nums) {
        numsMemory = new int[nums.length];
        numsMemory[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            numsMemory[i] = nums[i] + numsMemory[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if(left > right) {
            return 0;
        }
        if(left == 0) {
            return numsMemory[right];
        }
        return numsMemory[right] - numsMemory[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */ 
```
























