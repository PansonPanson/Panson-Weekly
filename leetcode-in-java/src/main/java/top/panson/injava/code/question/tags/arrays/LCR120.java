package top.panson.injava.code.question.tags.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Panson   用萝卜占坑的过程更容易理解
 * @create 2025-04-28
 */
public class LCR120 {
    class Solution {
        public int findRepeatDocument(int[] documents) {
            Set<Integer> set = new HashSet<>();
            for(int num : documents) {
                if(set.contains(num)) {
                    return num;
                }
                set.add(num);
            }
            return -1;
        }
    }

    class Solution1 {
        public int findRepeatNumber(int[] nums) {
            int temp;
            for(int i=0;i<nums.length;i++){
                while (nums[i]!=i){
                    if(nums[i]==nums[nums[i]]){
                        return nums[i];
                    }
                    temp=nums[i];
                    nums[i]=nums[temp];
                    nums[temp]=temp;
                }
            }
            return -1;
        }
    }

//    作者：derrick_sun
//    链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solutions/109471/yuan-di-zhi-huan-shi-jian-kong-jian-100-by-derrick/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
