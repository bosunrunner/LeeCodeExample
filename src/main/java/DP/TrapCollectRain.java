package DP;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class TrapCollectRain {
    public int trap(int[] height) {

        int len = height.length;
        int result = 0;

        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        for (int i = 1; i < len; i++) {
            if (height[i] <= height[deque.getFirst()]) {
                deque.push(i);
            } else {
                while (!deque.isEmpty() && height[i] > height[deque.getFirst()]) {
                    int mid = deque.pop();
                    if (!deque.isEmpty()){
                        int gao = Math.min(height[i],height[deque.getFirst()])-height[mid];
                        int di = i - deque.getFirst() - 1;
                        result += gao * di;
                    }

                }
                deque.push(i);

            }
        }
        return result;
    }
}
