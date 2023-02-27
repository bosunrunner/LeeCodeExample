package twoNodeTree;

public class BuildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = postorder[postorder.length - 1];

        int deltaIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                deltaIndex = i;
                break;
            }
        }
        int[] inLeft = new int[deltaIndex];
        int[] inRight = new int[inorder.length - 1 - deltaIndex];
        for (int i = 0; i < inLeft.length; i++) {
            inLeft[i] = inorder[i];
        }
        for (int i = 0; i < inRight.length; i++) {
            inRight[i] = inorder[i + deltaIndex + 1];
        }
        int[] postLeft = new int[deltaIndex];
        int[] postRight = new int[inorder.length - 1 - deltaIndex];
        for (int i = 0; i < postLeft.length; i++) {
            postLeft[i] = postorder[i];
        }
        for (int i = 0; i < postRight.length; i++) {
            postRight[i] = postorder[i + deltaIndex];
        }
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;
    }
}
