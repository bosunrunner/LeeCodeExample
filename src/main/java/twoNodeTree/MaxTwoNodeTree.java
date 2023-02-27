package twoNodeTree;

public class MaxTwoNodeTree {
    TreeNode maxTwoTree(int[] nums,int left,int right){
        // 终止条件
        if (right-left<1) return null;
        // 单层循环
        TreeNode node = new TreeNode();
        int maxValueIndex =left;
        int maxValue = nums[left];
        for (int i=left+1;i<right;i++){
            if (nums[i]>maxValue){
                maxValue=nums[i];
                maxValueIndex=i;
            }
        }
        node.val = nums[maxValueIndex];

        // 确定node的左右树
        node.left = maxTwoTree(nums,left,maxValueIndex);
        node.right =maxTwoTree(nums,maxValueIndex+1,right);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTwoTree(nums,0,nums.length);

    }
}
