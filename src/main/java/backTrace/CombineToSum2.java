package backTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineToSum2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    void backTrace(int[] candidates, int target, int sum, int startIndex) {
        // 终止条件
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        // 单层循环
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backTrace(candidates, target, sum, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);

        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrace(candidates, target, 0, 0);
        return result;

    }

}
