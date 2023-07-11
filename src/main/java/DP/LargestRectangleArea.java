package DP;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;

        // 数组扩容
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        for (int i = 1; i < newHeights.length; i++) {
            if (newHeights[i] >= newHeights[deque.getFirst()]) {
                deque.push(i);
            } else {
                while (!deque.isEmpty() && newHeights[i] < newHeights[deque.getFirst()]) {
                    int mid = deque.pop();
                    int left = deque.getFirst();
                    int h = newHeights[mid];
                    int w = i - left - 1;
                    result = Math.max(result, h * w);
                }
                deque.push(i);
            }
        }
        return result;
    }

}
