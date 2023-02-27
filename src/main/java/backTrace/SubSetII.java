package backTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    void backTrace(int[] nums,int startIndex,boolean[] used){
        // 终止条件
        result.add(new ArrayList<>(path));
        if (startIndex==nums.length){
            return;
        }
        // 单层循环
        for(int i = startIndex;i<nums.length;i++){
            if (i>0 && nums[i]==nums[i-1] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrace(nums,i+1,used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrace(nums,0,used);
        return result;

    }
}
