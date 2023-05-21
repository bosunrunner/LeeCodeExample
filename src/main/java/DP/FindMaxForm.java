package DP;

public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        // 定义dp及其下标含义
        int[][] dp = new int[m + 1][n + 1];

        // 确定递推公式以及初始化：二维0，1背包问题
        // 确定遍历顺序，先遍历物品，在遍历容量
        for (String str : strs) {
            int zeroNum = 0;
            int oneNum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zeroNum += 1;
                } else {
                    oneNum += 1;
                }
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
