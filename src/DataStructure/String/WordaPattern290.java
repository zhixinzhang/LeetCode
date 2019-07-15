package DataStructure.String;

import java.util.HashMap;

/**
 * Created by zhang on 2017/2/5.
 */
//本题跟 "Isomorphic Strings" 很类似，用两个HashMap, 记录从字符到字符串和字符串到字符的映射
public class WordaPattern290 {
    public static boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
       if (strArr.length != pattern.length() ) return  false;
        HashMap<Character,String> hashMap = new HashMap<>();
        for(int i = 0;i<pattern.length();i++){
            if (!hashMap.containsKey(pattern.charAt(i))){
                if (hashMap.size() != 0){
                    if (!hashMap.values().contains(strArr[i])){
                        hashMap.put(pattern.charAt(i),strArr[i]);
                    }else {
                        return  false;
                    }
                }else{
                    hashMap.put(pattern.charAt(i),strArr[i]);
                }

            }else{
                if(!hashMap.get(pattern.charAt(i)).equals(strArr[i])){
                    return false;
                }
            }
        }
        return true;
    }


    public  static  void main(String args[]){
        String pattern = "abba";
        String str = "dog dog dog dog";
       boolean a=   wordPattern(pattern,str);
        int axx=0;
    }
}
