package top.panson.injava.question.top100;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2022-01-18 15:03
 * @Author: Panson
 */
public class L075 {


    class Solution {
        // 参考： https://leetcode-cn.com/problems/sort-colors/solution/fei-chang-jian-ji-de-xie-fa-by-tchj-z9fp/
        public void sortColors(int[] nums) {
            int left=0,right=nums.length-1;
            int i=0;
            // left为数字0的右开边界，right为数字2的左开边界。
            while(i<=right){
                if(nums[i]==0)
                    swap(nums,i++,left++);
                else if(nums[i]==2)
                    swap(nums,i,right--);
                else
                    i++;
            }
        }
        private void swap(int[] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = new int[] {2,0,2,1,1,0};
        Solution1 solution11 = solution1;
        solution11.sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }


    public static class Solution1 {

        //  [2,0,2,1,1,0]
        public void sortColors(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return;
            }

            // all in [0, zero) = 0
            // all in [zero, i) = 1
            // all in [two, len - 1] = 2

            // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
            // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
            // 所以下面遍历到 0 的时候，先交换，再加
            int zero = 0;

            // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
            // 所以下面遍历到 2 的时候，先减，再交换
            int two = len;
            int i = 0;
            // 当 i == two 上面的三个子区间正好覆盖了全部数组
            // 因此，循环可以继续的条件是 i < two
            // [2,0,2,1,1,0]
            while (i < two) {
                if (nums[i] == 0) {
                    swap(nums, i, zero);
                    zero++;
                    i++;
                } else if (nums[i] == 1) {
                    i++;
                } else {
                    two--;
                    swap(nums, i, two);
                }
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
}
