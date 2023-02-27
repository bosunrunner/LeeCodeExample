package backTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    void backTrace(int[] nums,int startIndex){
        // 终止条件
        result.add(new ArrayList<>(path));
        if (startIndex==nums.length){
            return;
        }
        // 单层循环
        for(int i = startIndex;i<nums.length;i++){

            path.add(nums[i]);
            backTrace(nums,i+1);
            path.remove(path.size()-1);
        }

    }

    // 示例: 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums,0);
        return result;

    }
}
