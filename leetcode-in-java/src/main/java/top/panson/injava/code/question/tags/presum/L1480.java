package top.panson.injava.code.question.tags.presum;

class L1480 {
    public int[] runningSum(int[] nums) {
        int sumi = 0;
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = sumi + nums[i];
            sumi += nums[i];
        }
        return res;
    }
}