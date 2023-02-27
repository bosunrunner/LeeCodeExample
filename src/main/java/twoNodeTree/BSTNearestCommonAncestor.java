package twoNodeTree;

public class BSTNearestCommonAncestor {
    // 使用前序遍历

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root==null) return root;

        // 单层循环
        if (root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if (root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;

    }
}
