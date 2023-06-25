package DP;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // 定义dp及其下标含义,表示最大子序和
        int[] dp = new int[len];
        // 确定递推公式并初始化
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;

    }
}
