package DP;

import java.util.stream.IntStream;

public class LenOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len==1){
            return 0;
        }
        // 定义dp及其下标含义
        int[] dp = IntStream.generate(() -> 1).limit(len).toArray();
        int result = 0;
        // 确定递推公式并初始化 dp[i] = if(nums[i]>nums[j]) dp[i] = max(dp[i],dp[j]+1)
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}
