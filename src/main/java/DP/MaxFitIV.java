package DP;

public class MaxFitIV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        // 定义dp及确定其下标含义
        int[][] dp = new int[len][2 * k + 1];
        // 确定递推公式并初始化
        for (int i = 1; i < 2 * k; i = i + 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][2 * k];

    }
}
