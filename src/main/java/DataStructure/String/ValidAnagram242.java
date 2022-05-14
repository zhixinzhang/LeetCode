package DataStructure.String;

import java.util.HashMap;

/**
 * Created by zhang on 2017/2/4.
 */
public class ValidAnagram242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length() ) return  false;
        if (s.length()==0 && t.length()== 0) return  true;
        boolean result = true;
        HashMap<Character,Integer> hashMapS = new HashMap<Character, Integer>();
        HashMap<Character,Integer> hashMapT = new HashMap<Character, Integer>();

        for(int i = 0;i<s.length();i++){
            if (hashMapS.get(s.charAt(i)) == null){
                hashMapS.put(s.charAt(i),1);
            }else {
                int value = hashMapS.get(s.charAt(i));
                value ++;
                hashMapS.put(s.charAt(i),value);
            }
        }
        for(int i = 0;i<t.length();i++){
            if (hashMapT.get(t.charAt(i)) == null){
                hashMapT.put(t.charAt(i),1);
            }else {
                int value = hashMapT.get(t.charAt(i));
                value ++;
                hashMapT.put(t.charAt(i),value);
            }
        }
        if (!hashMapS.equals(hashMapT)) result = false;
//        for (Object hsKey: hashMapS.keySet()) {
//            if(!hashMapT.containsKey(hsKey)){
//                return  result = false;
//            }else{
//                if (hashMapS.get(hsKey) != hashMapT.get(hsKey)){
//                    return  result =false;
//                }
//            }
//        }
        return result;
    }



    public static  void main(String args[]){
            String s = "anagram";
            String t = "nagaram";

            isAnagram(s,t);

    }
}
