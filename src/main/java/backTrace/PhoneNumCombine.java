package backTrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumCombine {
    String[] letterMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new ArrayList<>();

    StringBuilder temp = new StringBuilder();

    void backTrace(String digits,int startIndex){
        // 终止条件
        if (startIndex==digits.length()){
            result.add(temp.toString());
            return;
        }
        // 单层循环
        String str = letterMap[digits.charAt(startIndex)-'0'];
        for (int i=0;i<str.length();i++){
            temp.append(str.charAt(i));
            backTrace(digits,startIndex+1);
            temp.deleteCharAt(temp.length()-1);
        }

    }


    public List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return result;
        }
        backTrace(digits,0);
        return result;

    }
}
