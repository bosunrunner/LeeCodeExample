package backTrace;

import java.util.ArrayList;
import java.util.List;

public class ResumeIPAddress {
    List<String> result = new ArrayList<>();


    void  backTrace(String s,int startIndex,int pointNum){
        if (pointNum==3){
            if (isValid(s,startIndex,s.length()-1)){
                result.add(s);
            }
            return;
        }

        for (int i=startIndex;i<s.length();i++){
            if (isValid(s,startIndex,i)){
                s = s.substring(0,i+1) +'.' + s.substring(i+1);
                pointNum +=1;
                backTrace(s,i+2,pointNum);
                pointNum -=1;
                s = s.substring(0,i+1)+s.substring(i+2); // 讲.删掉

            }else {
                break;
            }
        }

    }

    private boolean isValid(String s, int startIndex, int endIndex) {
        if (startIndex>endIndex){
            return false;
        }
        if (s.charAt(startIndex)=='0' && startIndex!=endIndex){
            return false;
        }
        int num = 0;
        for (int i = startIndex;i<=endIndex;i++){
            if (s.charAt(i)>'9' || s.charAt(i)<'0'){
                return false;
            }
            num = s.charAt(i)-'0'+num*10;
            if (num>255){
                return false;
            }
        }
        return true;
    }


    public List<String> restoreIpAddresses(String s) {
        if (s.length()>12){
            return result;
        }
        backTrace(s,0,0);
        return result;
    }
}
