package twoNodeTree;

public class NodeNum {
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0,rightDepth = 0;
        while (left!=null){
            leftDepth++;
            left= left.left;
        }
        while (right!=null){
            rightDepth++;
            right= right.right;
        }
        if (leftDepth==rightDepth){
            return 2<<leftDepth-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);


    }
}
