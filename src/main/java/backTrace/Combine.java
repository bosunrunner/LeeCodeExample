package backTrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();;
        List<Integer> path = new LinkedList<>();

        void backTrace(int n,int k,int startIndex){
            // 终止条件
            if ( path.size()==k){
                result.add(new ArrayList<>(path));
                return;
            }
            // 单层循环
            for (int i = startIndex;i<=n-(k-path.size())+1;i++){
                path.add(i);
                // 递归操作
                backTrace(n,k,i+1);
                path.remove(path.size()-1);
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            backTrace(n,k,1);
            return result;


        }
    }
}
