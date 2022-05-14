package DataStructure.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/2/1.
 */

//没做出来  可以继续学习
public class MiniumWindowSubstring76Hard {
    public static String minWindow(String s, String t) {
        String result = null;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int length = tChar.length;
        final  char[] tCharCopy = tChar.clone();
        List<String> str = new ArrayList<>();
        String tmpStr = "";
        int prePoint = 0;
        int[] point = {0,0};

        for(int i = 0;i<sChar.length;i++){
            if (length == 0){
                length = tCharCopy.length;
                tChar = tCharCopy;
            }
            if(t.contains(String.valueOf(sChar[i]))){
                prePoint = i;
                t.replace(sChar[i],'0');
                length -- ;
                tmpStr = tmpStr + String.valueOf(sChar[i]);
            }
            if (length == 0){
                if (str.size() == 0){
                    str.add(tmpStr);
                } else {
                    if (str.get(0).length()>tmpStr.length()){
                        //截取当前的
//                        tmpStr.indexOf(1,2);
                        str.clear();
                        str.add(tmpStr);
                        tmpStr = "";
                    }
                }
            }


        }
        return result;
    }




    public  static void main(String args[]){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        minWindow(s,t);

    }
}
