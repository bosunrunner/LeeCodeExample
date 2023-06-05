package DP;

import twoNodeTree.TreeNode;

public class DaJiaJieSheIII {
    public int rob(TreeNode root) {
        // 动态规划
        if (root == null) {
            return 0;
        }

        int[] dp_result = doTwoNode(root);
        return Math.max(dp_result[0], dp_result[1]);
    }

    private int[] doTwoNode(TreeNode root) {
        // 定义dp及其下标含义，int[2] dp dp[0]表示不偷当前节点，dp[1]表示偷当前节点
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        // 后续遍历
        int val = root.val;
        int[] left = doTwoNode(root.left);
        int[] right = doTwoNode(root.right);
        res[1] = val + left[0] + right[0];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;

    }
}
