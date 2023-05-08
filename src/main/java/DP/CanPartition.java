package DP;

import java.util.Arrays;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        // 定义dp及其小标含义，dp[j]表示最大和为j的对应的最大和
        int[] dp = new int[10001];
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int targetNum = sum / 2;
        // 确定递推公式及初始化
        for (int i = 0; i < nums.length; i++) {
            for (int j = targetNum; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[targetNum] == targetNum;
    }
}
