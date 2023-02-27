package twoNodeTree;

public class ConvertBST {
    int pre;
    void convert(TreeNode node){
        // 终止条件
        if (node==null){
            return;
        }
        // 单层逻辑循环
        TreeNode cur = node;
        convert(cur.right);
        cur.val +=pre;
        pre = cur.val;
        convert(cur.left);

    }

    public TreeNode convertBST(TreeNode root) {

        convert(root);
        return root;

    }
}
