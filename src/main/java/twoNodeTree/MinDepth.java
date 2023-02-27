package twoNodeTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root==null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                if (node.left==null && node.right==null) return depth;
            }
        }
        return depth;

    }
    public int minDepth2(TreeNode root) {
        return getDepth(root);

    }
    int getDepth(TreeNode node){
        if (node==null) return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (node.left==null && node.right!=null) {
            return 1+ rightDepth;
        }
        if (node.left!=null && node.right==null) {
            return 1+ leftDepth;
        }
        return 1+Math.min(leftDepth,rightDepth);
    }


}
