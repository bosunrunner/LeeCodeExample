package twoNodeTree;

public class PathSum {
    boolean pathSum(TreeNode node ,int count){
        if (node.left==null && node.right==null && count == 0){
            return true;
        }
        if (node.left == null && node.right == null){
            return false;
        }
        if (node.left!=null){
            if (pathSum(node.left,count- node.left.val)) return true;
        }
        if (node.right!=null){
            if (pathSum(node.right,count- node.right.val)) return true;
        }
        return false;

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) return false;
        return pathSum(root,targetSum-root.val);

    }
}
