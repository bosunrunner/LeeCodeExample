package twoNodeTree;

public class BSTInsert {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null){
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        if (root.val>val) root.left = insertIntoBST(root.left,val);
        if (root.val<val) root.right = insertIntoBST(root.right,val);
        return root;


    }
}
