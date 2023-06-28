package DP;

public class CountSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        int result = 0;
        // 定义dp及其下标含义，dp[i][j]表示s的[i,j]区间中回文字符串的数量
        boolean[][] dp = new boolean[len][len];
        // 确定递推公式并初始化 dp[i][j] = dp[i+1][j-1]
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
