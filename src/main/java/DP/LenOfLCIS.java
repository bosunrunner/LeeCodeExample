package DP;

import java.util.stream.IntStream;

public class LenOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        // 确定dp及其下标含义
        int[] dp = IntStream.generate(() -> 1).limit(len).toArray();
        // 确定递推公式并初始化 if(nums[i]>nums[i-1]) dp[i] = dp[i-1]+1;
        int result = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }

}
