
*日拱一卒*

_________________

# 1 一周见闻

## 1.1 技术文章

## 1.2 泛互联网文章



# 2 技术总结



# 3 Algorithm(算法题)
+ [977. 有序数组的平方](https://leetcode.cn/problems/squares-of-a-sorted-array/description/)
```java

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * 示例 1：
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     *
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 已按 非递减顺序 排序
     * 进阶：
     *
     * 请你设计时间复杂度为 O(n) 的算法解决本问题
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int p1 = 0;
        int p2 = n - 1;
        int[] res = new int[n];
        int i = n - 1;
        while(p1 <= p2) {
            if(nums[p2] * nums[p2] > nums[p1] * nums[p1]) {
                res[i] = nums[p2] * nums[p2];
                p2--;
            } else {
                res[i] = nums[p1] * nums[p1];
                p1++;
            }
            i--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
```
























