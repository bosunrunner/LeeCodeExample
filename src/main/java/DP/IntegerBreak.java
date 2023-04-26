package DP;

public class IntegerBreak {
    public int integerBreak(int n) {
        //确定dp及其下标含义
        int[] dp = new int[n + 1];
        dp[2] = 1;
        //确定递推公式
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, j * dp[i-j]));
            }
        }
        return dp[n];

    }
}
