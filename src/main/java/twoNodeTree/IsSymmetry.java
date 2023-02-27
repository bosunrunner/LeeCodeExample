package twoNodeTree;

public class IsSymmetry {
    public boolean isSymmetric(TreeNode root) {
        boolean result = compare(root.left,root.right);
        return result;

    }

    Boolean compare(TreeNode left,TreeNode right){
        if (left==null && right!=null) return false;
        if (right==null && left!=null) return false;
        if (right==null && left==null) return true;

        if (left.val != right.val) return false;

        boolean outside = compare(left.left,right.right);
        boolean inside = compare(left.right,right.left);
        boolean result = outside && inside;
        return  result;

    }
}
