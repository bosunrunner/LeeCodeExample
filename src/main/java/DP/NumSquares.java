package DP;

import java.lang.management.ManagementFactory;

public class NumSquares {
    public int numSquares(int n) {
        // 定义dp 及其下标含义
        int[] dp = new int[n + 1];
        // 确定dp得递推公式并初始化
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 确定遍历顺序
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
