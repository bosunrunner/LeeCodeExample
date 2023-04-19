package greedyalgorithm;


import twoNodeTree.TreeNode;

public class MinCameraCover {
    int result = 0;

    int getNodeStatus(TreeNode node) {
        // 状态 0：无覆盖，1，有覆盖，2 有摄像头

        // 终止条件
        if (node == null) {
            return 1;
        }
        int left = getNodeStatus(node.left);
        int right = getNodeStatus(node.right);
        // 如果两个都有覆盖
        if (left == 1 && right == 1) return 0; // 无覆盖
        //  至少一个没有覆盖
        if (left == 0 || right == 0) {
            result++;
            return 2;  // 加摄像头
        }
        // 至少一个有摄像头
        if (left == 2 || right == 2) return 1; // 有覆盖

        return -1;
    }

    public int minCameraCover(TreeNode root) {

        if (getNodeStatus(root) == 0) {
            result++;
        }
        return result;
    }
}
