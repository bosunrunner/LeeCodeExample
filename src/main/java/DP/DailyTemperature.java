package DP;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperature {
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];

        Deque<Integer> deque = new LinkedList<>();

        deque.push(0);
        for (int i = 1; i < len; i++) {
            if (temperatures[i] <= temperatures[deque.getFirst()]) {
                deque.push(i);
            } else {
                while (!deque.isEmpty() && temperatures[i] > temperatures[deque.getFirst()]) {
                    int tem = i - deque.getFirst();
                    result[deque.getFirst()] = tem;
                    deque.pop();
                }
                deque.push(i);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] result = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(result.toString());
    }
}
