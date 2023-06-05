package DP;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 使用动态规划穷举法也可以实现，就是有可能会在不优化的情况下超出空间

        // 定义dp,及其下标含义
        int[] dp = new int[s.length() + 1];
        // 初始化并确定遍历顺序,先遍历背包容量，再遍历物品 dp[i] = dp[i-j] && subStr(i-j)==word
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (wordDict.contains(str) && dp[j] == 1) {
                    dp[i] = 1;
                }
            }
        }
        return dp[s.length()] == 1;

    }
}
