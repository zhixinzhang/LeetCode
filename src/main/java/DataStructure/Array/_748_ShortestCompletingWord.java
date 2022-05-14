package DataStructure.Array;
import java.util.*;
/**
 * Created by zhang on 2018/1/12.
 */
public class _748_ShortestCompletingWord {
    public static void main(String[] args){
        shortestCompletingWord("1s3 PSt",new String[]{"step", "steps", "stripe", "stepple"});

    }
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        String s = licensePlate.toLowerCase();
        if(licensePlate == null || licensePlate == "") return words[0];
        char[] arr = s.toCharArray();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            if(arr[i] >='a' && arr[i]<='z'){
                hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            }
        }
        String res = "";
        for(String w : words){
            String word = w.toLowerCase();
            HashMap<Character,Integer> curHm = (HashMap)hm.clone();
            for(int i = 0;i<word.length();i++){
                Character curChar = word.charAt(i);
                if(curHm.containsKey(curChar)){
                    int freq = curHm.get(curChar);
                    if(freq == 1)
                        curHm.remove(curChar);
                    else
                        curHm.put(curChar,freq - 1);
                        int a = 0;
                }

            }
            if(curHm.size() == 0){
                if(res == "")
                    res = word;
                res = res.length() > word.length() ? word : res;
            }
        }
        return res;
    }
}
