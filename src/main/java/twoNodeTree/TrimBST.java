package twoNodeTree;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 终止条件
        if (root==null){
            return null;
        }
        // 单层逻辑
        if (root.val<low){
            root = trimBST(root.right,low,high);
            return root;
        }
        if (root.val>high){
            root = trimBST(root.left,low,high);
            return root;
        }
        // 开始递归

        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);

        return root;

    }
}
