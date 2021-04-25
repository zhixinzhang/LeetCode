package Company.BloomBerg;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/24/2021 2:49 PM
 * <p>
 * Description:
 *
Giving a string, if all characters in the string occur the same times, we define it a cool string. for example "aabbcc", "abc", "abcabcabc" are all coll string. Please write a function to detact if a string is a cool string, or it can become a cool string by just removing on character in that string.
example string:
"aabbbcc" true by remoing b
"aabbccd" return true by removing d
"aaabbbccdd" return false as we need to remove both a and b

 * Similar task :
 * Key Point:
 *
 * https://www.1point3acres.com/bbs/thread-725243-1-1.html
 */

public class _CoolString_ {
    public static void main(String[] args){
        isValid("aaabbbccdd");
    }


    private static boolean isValid(String s){
        if (s == null || s.length() <= 1) {
            return true;
        }

        int[] cache = new int[26];
        for (char c : s.toCharArray()){
            cache[c - 'a']++;
        }

        //[3, 3, 2, 2, 1]
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 26; i++){
            if (cache[i] == 0)
                continue;

            set.add(cache[i]);
            if (set.size() >= 3) {
                return false;
            }

            min = Math.min(min, cache[i]);
        }

        int distance = 0;
        for(int i = 0; i < 26; i++){
            if (cache[i] == 0)
                continue;

            distance += cache[i] - min;
            if (distance > 1)
                return false;
        }

        return true;
    }
}
