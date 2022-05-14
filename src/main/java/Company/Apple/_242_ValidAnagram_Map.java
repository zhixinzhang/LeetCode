package Company.Apple;

import java.util.HashMap;

/**
 * Created by zhang on 2018/2/7.
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.
 */
// O(n) O(n)
public class _242_ValidAnagram_Map {
    public static boolean isAnagram(String s, String t) {
        if (s.length() > t.length() || s.length() < t.length())
            return false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i <s.length();i++){
            Character c = s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for (int i = 0; i<t.length();i++){
            Character c = t.charAt(i);
            if (hm.containsKey(c)){
                hm.put(c,hm.get(c)-1);
                if (hm.get(c) < 0)
                    return false;
            }else{
                return false;
            }
        }
        for (Character key : hm.keySet()) {
            int val = hm.get(key);
            if (val != 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        isAnagram("anagram","nagaram");
    }
}
