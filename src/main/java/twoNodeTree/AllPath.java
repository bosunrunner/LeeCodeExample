package twoNodeTree;

import java.util.ArrayList;
import java.util.List;

public class AllPath {

    public List<String> binaryTreePaths(TreeNode root) {
        return getPaths(root, "", new ArrayList<String>());

    }

    List<String> getPaths(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            path+=root.val;
            result.add(path);
            return result;
        }
        path += root.val;
        if (root.left != null) {
            getPaths(root.left, path + "->", result);
        }
        if (root.right != null) {
            getPaths(root.right, path + "->", result);
        }
        return result;
    }
}
