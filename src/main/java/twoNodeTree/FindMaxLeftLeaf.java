package twoNodeTree;

public class FindMaxLeftLeaf {
    int maxValue;
    int maxDepth = -1;

    void getMaxDepth(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                maxValue = node.val;
            }
        }
        if (node.left != null) {
            getMaxDepth(node.left, depth + 1);
        }
        if (node.right != null) {
            getMaxDepth(node.right, depth + 1);
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        getMaxDepth(root, 0);
        return maxValue;

    }
}
