package top.panson.injava.code.question.tags.difarray;

/**
 * @author Panson
 * @create 2024-03-10
 */
public class L0995 {

    class Solution01 {
        public int minKBitFlips(int[] nums, int k) {
            // 使用模拟暴力求解
            int n = nums.length;
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(nums[i] == 0) {
                    // 倒数第 k - 1 位为0
                    if(i + k > n) {
                        return -1;
                    }
                    for(int j = i; j < i + k; j++) {
                        nums[j] ^= 1;
                    }
                    count++;
                }
            }
            return count;
        }
    }

    class Solution02 {
        public int minKBitFlips(int[] nums, int k) {
            int n = nums.length;
            int[] diff = new int[n + 1];
            int ans = 0, revCnt = 0;
            for (int i = 0; i < n; ++i) {
                revCnt += diff[i];
                // 若 nums[i]+revCnt 是偶数，则说明当前元素的实际值为 0
                if ((nums[i] + revCnt) % 2 == 0) {
                    if (i + k > n) {
                        return -1;
                    }
                    ++ans;
                    ++revCnt;
                    --diff[i + k];
                }
            }
            return ans;
        }
    }


}
