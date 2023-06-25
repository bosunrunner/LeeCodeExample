package DP;

public class MinDistance2 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 定义dp及其下标含义，以i-1结尾得word1和以j-1结尾word2，最少操作相同
        int[][] dp = new int[m + 1][n + 1];
        // 确定递推公式并初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }
}
