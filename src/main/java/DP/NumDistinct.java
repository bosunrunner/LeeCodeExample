package DP;

public class NumDistinct {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        // 定义dp及其下标含义，dp[i][j] 表示s[0,i-1]（表示范围-闭区间）子序列中包含t[0,j-1]得个数
        int[][] dp = new int[m + 1][n + 1];
        // 确定递推公式并初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        // 确定遍历顺序
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];

    }
}
