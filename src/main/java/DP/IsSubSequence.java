package DP;

public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        // 定义dp及其下标含义,表示最长公共子序列
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n] == m;
    }
}
