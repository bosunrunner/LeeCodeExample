package DP;

public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        // 定义dp及其下标含义,dp[i][j]表示s[i,j]区间最大回文字符序列数
        int[][] dp = new int[len][len];
        // 确定递推公式并初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
