package backTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineToSum {


    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    void backTrace(int[] nums,int target,int sum,int startIndex){
        if (sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum>target){
            return;
        }

        for(int i = startIndex;i<nums.length ;i++){
            if (sum+nums[i]>target){
                break;
            }
            sum +=nums[i];
            path.add(nums[i]);
            backTrace(nums,target,sum,i);
            sum -=nums[i];
            path.remove(path.size()-1);
        }

    }



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 先进行排序
        backTrace(candidates,target,0,0);
        return result;
    }
}
