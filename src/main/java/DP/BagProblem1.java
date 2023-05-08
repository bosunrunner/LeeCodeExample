package DP;

public class BagProblem1 {
    public static void main(String[] args) {
        int[] weights = {1,3,4};
        int[] values = {15,20,30};
        int bagSize = 4;
        testBagProblem01(weights,values,bagSize);
    }

    private static void testBagProblem01(int[] weights, int[] values, int bagSize) {
        // 定义dp,及其下表含义
        int weightNum = weights.length;
        int[][] dp = new int[weightNum][bagSize+1];
        // 推导公式，逻辑推理
        // 初始化
        for (int i=weights[0];i<=bagSize;i++){
            dp[0][i] = values[0];
        }
        // 确定遍历顺序,先遍历物品，在遍历重量
        for (int i=1;i<weights.length;i++){
            for (int j=0;j<=bagSize;j++){
                if (j<weights[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < weightNum; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }


}
