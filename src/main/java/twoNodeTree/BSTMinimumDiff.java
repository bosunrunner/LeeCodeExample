package twoNodeTree;

public class BSTMinimumDiff {
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        // 终止条件
        if (root == null) return result;
        // 单层循环
        result = getMinimumDifference(root.left);
        if (pre != null) {
            result = Math.min(result,root.val-pre.val);

        }
        pre = root;
        result = getMinimumDifference(root.right);
        return result;
    }

}
