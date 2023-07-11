package DP;

import java.util.*;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        int[] result = new int[lenA];
        Arrays.fill(result,-1);

        Map<Integer,Integer> nums1ToIndex = new HashMap<>();
        for (int i=0;i<lenA;i++){
            nums1ToIndex.put(nums1[i],i);
        }
        Deque<Integer> deque = new LinkedList<>();

        deque.push(nums2[0]);
        for (int i=1;i<lenB;i++){
            if (nums2[i]<=nums2[i-1]){
                deque.push(nums2[i]);
            }else {
                while (!deque.isEmpty() && nums2[i]>deque.getFirst()){
                    int top = deque.getFirst();
                    if (nums1ToIndex.containsKey(top)){
                        result[nums1ToIndex.get(top)] = nums2[i];
                    }
                    deque.pop();
                }
                deque.push(nums2[i]);
            }
        }

        return result;

    }
}
