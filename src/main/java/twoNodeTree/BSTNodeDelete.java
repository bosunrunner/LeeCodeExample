package twoNodeTree;

public class BSTNodeDelete {

    public TreeNode deleteNode(TreeNode root, int key) {
        // 终止条件以及单层逻辑
        if (root==null) return root;

        if (root.val == key){
            if (root.left==null){
                return root.right;
            }else if (root.right==null){
                return root.left;
            }else {
                TreeNode right = root.right;
                TreeNode cur = null;
                while (right!=null){
                    cur = right;
                    right = right.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        // 开始递归
        if (root.val>key) root.left = deleteNode(root.left,key);
        if (root.val<key) root.right = deleteNode(root.right,key);

        return root;

    }
}
