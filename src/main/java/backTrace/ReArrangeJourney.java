package backTrace;

import java.util.*;

public class ReArrangeJourney {
    Map<String,Map<String ,Integer>> map = new HashMap<>();
    List<String> result = new LinkedList<>();

    boolean backTrace(int ticketNum){
        if (result.size()==ticketNum+1){
            return true;
        }
        if (map.containsKey(result.get(result.size()-1))){  // 防止出现null
            for (Map.Entry<String ,Integer> parSet:map.get(result.get(result.size()-1)).entrySet()){
                int count = parSet.getValue();
                if (count>0){
                    result.add(parSet.getKey());
                    parSet.setValue(count-1);
                    if (backTrace(ticketNum)) return true;
                    result.remove(result.size()-1);
                    parSet.setValue(count);
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        // 构建起点到目的地的映射集合

        for (List<String> tmp : tickets) {
            String from = tmp.get(0);
            String to = tmp.get(1);
            if (map.containsKey(from)) {
                Map<String, Integer> tmpMap = map.get(from);
                tmpMap.put(to, tmpMap.getOrDefault(to, 0) + 1);
                map.put(from, tmpMap);
            } else {
                Map<String, Integer> tmpMap = new TreeMap<>(); // 升序Map
                tmpMap.put(to, 1);
                map.put(from, tmpMap);
            }
        }
        // 使用回溯算法解题
        result.add("JFK");
        backTrace(tickets.size());
        return new ArrayList<>(result);
    }
}
