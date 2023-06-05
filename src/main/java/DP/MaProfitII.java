package DP;

public class MaProfitII {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        // 定义dp及其下标含义
        int[][] dp = new int[prices.length][2];
        // 确定递推公式并初始化
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
