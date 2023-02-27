package backTrace;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SplitHuiWen {
    List<List<String>> result = new ArrayList<>();

    Deque<String> path = new LinkedList<>();


    void backTrace(String s, int startIndex) {
        //终止条件
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 单层循环
        for (int i = startIndex; i < s.length(); i++) {
            if (isHuiWen(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backTrace(s, i + 1);
            path.removeLast();
        }

    }

    private boolean isHuiWen(String s, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        backTrace(s, 0);
        return result;
    }



}
