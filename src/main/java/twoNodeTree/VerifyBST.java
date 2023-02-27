package twoNodeTree;


public class VerifyBST {

    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {

        // 终止条件
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;

        boolean right = isValidBST(root.right);


        return left && right;

    }
}
