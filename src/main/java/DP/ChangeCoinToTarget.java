package DP;

public class ChangeCoinToTarget {

    public int change(int amount, int[] coins) {

        // 定义 dp及其下标含义,总金额为j得方法有dp[j]种
        int[] dp = new int[amount + 1];
        // 确定递推公式并初始化，dp[j] += dp[j-coins[i]]+1
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];


    }
}
