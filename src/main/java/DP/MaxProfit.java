package DP;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        // 确定dp及其下标含义，dp[i][0]表示第i天持有的现金，dp[i][1]表示第i天交易股票后的现金
        int[][] dp = new int[prices.length][2];
        // 确定递推公式并初始化
        if (prices.length == 0) {
            return 0;
        }
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
