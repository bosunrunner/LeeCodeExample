package twoNodeTree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class layerTraverse {
    public List<List<Integer>> levelOrderBottom(twoNodeTree.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;
        Queue<twoNodeTree.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            result.add(temp);
        }
        return result;
    }

}
