package DP;

public class ClimbStairs {
    public int climbStairs(int n) {
        // 确定数组及其下标含义,dp[i]表示到达第i个台阶共有多少方法
        int[] dp = new int[n+1];
        // 确定递推公式：dp[i] = dp[i-1] + dp[i-2]
        if (n==1){
            return 1;
        }
        dp[1] =1;
        dp[2] = 2;
        for (int i=3;i<n+1;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
