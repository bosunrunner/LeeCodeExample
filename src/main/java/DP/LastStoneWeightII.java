package DP;

import java.util.Arrays;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        // 定义dp及其下标含义
        int[] dp = new int[1501];
        int sum = Arrays.stream(stones).sum();
        int targetNum = sum / 2;
        // 确定递推公式并初始化
        // 确定遍历顺序
        for (int i = 0; i < stones.length; i++) {
            for (int j = targetNum; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[targetNum] - dp[targetNum];
    }
}
