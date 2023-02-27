package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result =  new int[k];
        // 1. 统计nums中各个数字出现的频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 2. 根据map的value值，形成一个小顶堆

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));

        for (Map.Entry<Integer,Integer> entry:entries){
            priorityQueue.offer(entry);
            if (priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        for (int i= k-1;i>=0;i--){
            result[i]= priorityQueue.poll().getKey();
        }
        return result;

    }
}
