package backTrace;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubSequence {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    void backTrace(int[] nums, int startIndex){
        if (path.size()>1){
            result.add(new ArrayList<>(path));
        }
        boolean[] used = new boolean[201];
        for (int i = startIndex;i<nums.length;i++){
            if ((!path.isEmpty() && nums[i]<path.get(path.size()-1)) || used[nums[i] + 100]){
                continue;
            }
            used[nums[i] + 100]=true;
            path.add(nums[i]);
            backTrace(nums,startIndex);
            path.remove(path.size()-1);
        }
    }


    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrace(nums,0);
        return result;

    }
}
