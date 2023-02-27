package twoNodeTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindModeNum {

    ArrayList<Integer> resList = new ArrayList<>();
    int maxCount;
    int count;
    TreeNode pre;

    void findMostNums(TreeNode node) {
        // 终止条件
        if (node == null) {
            return;
        }
        findMostNums(node.left);
        //单层逻辑
        if (pre == null || node.val != pre.val) {
            count = 1;
        } else {
            count += 1;
        }
        if (count > maxCount) {
            maxCount = count;
            resList.clear();
            resList.add(node.val);
        } else if (count == maxCount) {
            resList.add(node.val);
        }
        pre = node;
        findMostNums(node.right);

    }

    public int[] findMode(TreeNode root) {
        findMostNums(root);

        int[] result = new int[resList.size()];
        for (int i=0;i<resList.size();i++){
            result[i] = resList.get(i);
        }
        return result;

    }
}
