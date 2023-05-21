package DP;

import java.util.Arrays;

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        // left = (target+right)/2
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 != 0) return 0;
        if (Math.abs(target)>sum) return 0;
        int end = (sum+target)/2;
        // 定义dp及其下标含义 dp[j]表示和为j的方法数
        int[] dp = new int[end+1];
        // 确定递推公式以及初始化 dp[j] += dp[j-nums[i]]
        dp[0] = 1;
        for (int num : nums) {
            for (int j = end; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[end];
    }

    public static void main(String[] args) {
        new FindTargetSumWays().findTargetSumWays(new int[]{1,1,1,1,1},3);
    }
}
