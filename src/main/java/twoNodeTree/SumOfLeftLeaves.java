package twoNodeTree;

public class SumOfLeftLeaves {

    int leftLeavesValue(TreeNode node){

        int leftNodeLeafVal = leftLeavesValue(node.left);
        int rightNodeLeafVal = leftLeavesValue(node.right);
        int leftValue = 0;
        if (node.left!=null && node.left.left==null && node.left.right==null){
            leftValue = node.left.val;
        }

        return leftValue+leftNodeLeafVal+rightNodeLeafVal;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) return 0;
        return leftLeavesValue(root);

    }
}
