package DP;

public class DaJiaJieSheII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 由于是环形，因此考虑两种情况，分别掐头去尾，然后动态规划取最大值
        int tou = dp(nums, 0, nums.length - 1);
        int wei = dp(nums, 1, nums.length);
        return Math.max(tou, wei);
    }

    private int dp(int[] nums, int startIndex, int endIndex) {
        // 定义dp及其下标含义
        if (endIndex - startIndex == 1) {
            return nums[startIndex];
        }
        int[] dp = new int[nums.length - 1];
        // 定义递推公式及其下标含义
        dp[0] = nums[startIndex];
        dp[1] = Math.max(nums[startIndex], nums[startIndex + 1]);

        for (int i = startIndex + 2; i < endIndex; i++) {
            int index;
            if (startIndex==1){
                index = i-1;
            }else {
                index = i;
            }
            dp[index] = Math.max(dp[index - 2] + nums[i], dp[index - 1]);
        }
        return dp[nums.length - 2];
    }
}
