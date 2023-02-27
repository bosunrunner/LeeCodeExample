package backTrace;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    void backTrace(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            path.add(nums[0]);
            used[i] = true;
            backTrace(nums,used);
            used[i] = false;
            path.remove(path.size()-1);
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        backTrace(nums,new boolean[nums.length]);
        return result;

    }
}
