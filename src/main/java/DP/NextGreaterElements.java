package DP;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElements {


    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        int[] result = new int[len];
        Arrays.fill(result, -1);
        for (int i = 1; i < 2 * len; i++) {
            if (nums[i % len] <= nums[deque.getFirst()]) {
                deque.push(i%len);
            } else {
                while (!deque.isEmpty() && nums[i%len] > nums[deque.getFirst()]) {
                    int index = deque.getFirst();
                    result[index] = nums[i%len];
                    deque.pop();
                }
                deque.push(i%len);

            }
        }
        return result;

    }
}
