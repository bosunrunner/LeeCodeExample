package DP;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // 确定dp大小及其含义
        int[][] dp = new int[m][n];

        //确定递推公式 初始化
        for (int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for (int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        // 确定遍历顺序
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
