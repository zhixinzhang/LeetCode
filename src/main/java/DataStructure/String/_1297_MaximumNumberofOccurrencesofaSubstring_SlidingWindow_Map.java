package DataStructure.String;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/4/2021 4:07 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _1297_MaximumNumberofOccurrencesofaSubstring_SlidingWindow_Map {

    public int maxFreq_slidingWindow(String s, int maxLetters, int minSize, int maxSize) {

        Map<String, Integer> map = new HashMap<>();
        int i = 0, j = 0, res = 0, freq[] = new int[26];

        while(j < s.length()){
            if(++freq[s.charAt(j++) - 'a'] == 1)//first occurence in window
                --maxLetters;

            while(maxLetters < 0 || j - i > minSize)//more than required alphabets in the window or substring length greater than minSize
                if(--freq[s.charAt(i++) - 'a'] == 0)//deleted last occurence from the window
                    ++maxLetters;

            if(j - i == minSize)
                res = Math.max(res, map.merge(s.substring(i, j), 1, Integer::sum));//store the largest count
        }
        return res;
    }

    // O(n * minSize)
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.length() == 0)
            return 0;

        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length() - minSize + 1; i++){
            String curS = s.substring(i, i + minSize);
            if(isValid(curS, maxLetters)) {
                hm.put(curS, hm.getOrDefault(curS, 0) + 1);
                max = Math.max(max, hm.get(curS));
            }
        }

        return max;
    }

    private boolean isValid(String s, int k){
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            set.add(c);
        }

        return set.size() <= k;
    }
}
