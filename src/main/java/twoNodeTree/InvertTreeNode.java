package twoNodeTree;

public class InvertTreeNode {

    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return root;
        }
        TreeNode tem = root.left;
        root.left=root.right;
        root.right=tem;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
}
