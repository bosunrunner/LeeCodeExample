package twoNodeTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinumDepth {
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
}
