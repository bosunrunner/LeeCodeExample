package DP;

public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        // 定义dp及其下标含义
        int[] dp = new int[target + 1];
        // 确定dp得递推公式以及初始化: 排列求和问题
        dp[0] = 1;
        // 确定遍历顺序，先排列容量，再排列物品
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
