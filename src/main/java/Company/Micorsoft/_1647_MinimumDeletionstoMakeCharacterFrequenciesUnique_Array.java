package Company.Micorsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Luke(New Man)  Zhang
 * @Date: 2021/1/2 0:17
 * Link :
 */
public class _1647_MinimumDeletionstoMakeCharacterFrequenciesUnique_Array {

    public static int minDeletions(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int[] cache = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i ++) {
            cache[s.charAt(i) - 'a']++;
        }

        Set<Integer>  visited = new HashSet<>();
        for (int i = 0; i < 26; i++){
            int current_freq = cache[i];
            while (current_freq > 0) {
                if (!visited.contains(current_freq)) {
                    visited.add(current_freq);
                    break;
                }
                current_freq --;
                res++;
            }

        }

        return res;
    }

    public static void main (String[] args){
        minDeletions("aaabbbbbccd");
    }
}
