package backTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute2 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    void backTrace(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backTrace(nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backTrace(nums, new boolean[nums.length]);
        return result;
    }
}
