package top.panson.injava.question.top100;

/**
 * 盛水最多的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2022-01-13 15:51
 * @Author: Panson
 */
public class L011 {

    public static class Solution {
        public static void main(String[] args) {
            System.out.println(maxArea(new int[] {1,1}));
            System.out.println(maxArea(new int[] {4,3,2,1,4}));
            System.out.println(maxArea(new int[] {1,2,1}));
        }

        /**
         * 核心思路是双指针，移动短板，只有移动短板才有可能让面积变大
         * @param height
         * @return
         */
        public static int maxArea(int[] height) {
            int maxArea = 0;
            int left = 0;
            int right = height.length - 1;
            while(left < right) {
                int currentArea = Math.min(height[left], height[right]) * (right - left);
                maxArea = Math.max(maxArea, currentArea);
                if(height[left] < height[right]) {
                    left++;
                }else {
                    right--;
                }
            }
            return maxArea;
        }

    }
}
