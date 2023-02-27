package backTrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombineII {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();


    void backTrace(int k,int sum,int n,int startIndex){
        // 终止条件
        if (sum>n){
            return;
        }
        if (path.size()==k ){
            if (sum==n){
                result.add(new ArrayList<>(path));
                return;
            }
            return;
        }
        // 单层逻辑
        for (int i = startIndex;i<=9-(k-path.size())+1;i++){
            sum +=i;
            path.add(i);
            backTrace(k,sum,n,i+1);  // 递归
            sum -=i;
            path.remove(path.size()-1);  // 回溯
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrace(k,0,n,1);
        return result;

    }
}
