package twoNodeTree;

public class NearestCommonAncestor {
    // 使用后序遍历，先遍历叶子节点

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if(root==null || p.val == root.val || q.val == root.val) return root;
        // 单层逻辑
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left!=null && right!=null){
            return root;
        }else if (left==null && right!=null){
            return right;
        }else {
            return left;
        }

    }
}
