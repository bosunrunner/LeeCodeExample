package twoNodeTree;

public class SortArrayToBST {
    // 首先要明确一点，区间为左闭右闭
    TreeNode sortNumsToBST(int[] nums,int left,int right){
        // 终止条件
        if (left>right){
            return null;
        }
        // 单层循环
        int mid = left+(right-left)>>1;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortNumsToBST(nums,left,left+mid-1);
        node.right = sortNumsToBST(nums,mid+1,right);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return sortNumsToBST(nums,0,nums.length-1);


    }
}
