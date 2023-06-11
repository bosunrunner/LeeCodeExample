package DP;

public class MaxProfitV {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // 确定dp及其下标含义，总共有四种状态：买入、卖出（两天前和一天前）、今天卖出和冷冻期
        int[][] dp = new int[len][4];
        // 确定递推公式并初始化
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[len - 1][1], Math.max(dp[len - 1][2], dp[len - 1][3]));
    }
}
