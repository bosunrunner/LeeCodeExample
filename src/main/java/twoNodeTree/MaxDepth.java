package twoNodeTree;

public class MaxDepth {
    int getDepth(TreeNode node){
        if (node==null) return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return 1+Math.max(leftDepth,rightDepth);

    }
    public int maxDepth(TreeNode root) {
        return getDepth(root);

    }
}
