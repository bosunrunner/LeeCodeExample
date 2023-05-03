package DP;

public class NumTrees {

    public int numTrees(int n) {
        // 确定dp及其下标含义
        int[] dp = new int[n+1];
        // 确定递推公式并初始化
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
