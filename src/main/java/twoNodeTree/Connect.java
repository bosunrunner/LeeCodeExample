package twoNodeTree;

import java.util.LinkedList;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Connect {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root==null) return null;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node nodePre = new Node(),node=new Node();
            for (int i=0;i<size;i++){
                if (i==0){
                    nodePre = queue.poll();
                    node= nodePre;
                }else {
                    node = queue.poll();
                    nodePre.next = node;
                    nodePre = nodePre.next;
                }
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            nodePre.next = null;
        }
        return root;
    }
}
