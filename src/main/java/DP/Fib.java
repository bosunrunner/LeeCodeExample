package DP;

public class Fib {
    public int fib(int n) {
        // 确定数组及其下标含义
        int[] dp = new int[2];
        if (n==0){
            return dp[0];
        }
        // 找到递归公式 dp[i] = dp[i-1]+dp[i-2]
        // 初始化数组
        dp[1] = 1;
        // 确定遍历顺序，从前往后遍历
        for (int i=2;i<n+1;i++){
            int tem = dp[1];
            dp[1] = dp[0]+dp[1];
            dp[0] = tem;
        }
        return dp[1];
    }
}
