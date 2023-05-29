package Company.Wepay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Time complexity: O(nlog⁡n)
public class _242_ValidAnagram_Map_Sort {
    public static void main(String[] args){
        isAnagram_Map("anagram","nagaram");
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram_Array(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram_Map(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> cache = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            
            if (cS == cT) {
                continue;
            }
            int countS = cache.getOrDefault(cS, 0);
            int countT = cache.getOrDefault(cT, 0);
            countS ++;
            countT --;
            cache.put(cS, countS);
            cache.put(cT, countT);
        }

        for (Integer v : cache.values()){
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}
