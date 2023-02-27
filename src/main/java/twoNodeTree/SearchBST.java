package twoNodeTree;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        // 终止条件
        if (root==null || root.val == val){
            return root;
        }
        // 单层循环
        if (root.val > val) return searchBST(root.left,val);
        return searchBST(root.right,val);

    }
}
