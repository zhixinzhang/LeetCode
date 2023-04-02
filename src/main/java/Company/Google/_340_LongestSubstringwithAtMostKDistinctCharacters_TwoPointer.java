package Company.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/12/3.
 * 这道题本质要维护一个窗口，即要维护一个hashmap，key为字符，value为窗口内的该字符的个数，然后在窗口扩张过程中
 * ，检查chars[end]是否被包含在map中，
 * 或者map的大小是否小于k，如果是直接添加；否则就要转为收缩，即start开始收缩，直到到达合适位置
 */
public class _340_LongestSubstringwithAtMostKDistinctCharacters_TwoPointer {
    //basic idea  use hashmap to store each character counter
    //for loop String from left to right
    //
    public static void main(String[] args){
        lengthOfLongestSubstringKDistinct_HashMap_SlidingWindow("abbaeeeffh",2);
    }

    public static int lengthOfLongestSubstringKDistinct_HashMap_SlidingWindow(String s, int k) {
        int start = 0;
        int maxLen = 0;
        // Key: letter; value: the number of occurrences.
        Map<Character, Integer> map = new HashMap<>();
        int i;
        for (i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                while (map.size() > k) {
                    char startChar = s.charAt(start++);
                    int count = map.get(startChar);
                    if (count > 1) {
                        map.put(startChar, count - 1);
                    } else {
                        map.remove(startChar);
                    }
                }
            }

            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    // 换成int[]
    public int lengthOfLongestSubstringKDistinct_int(String s, int k) {
        if (s.length() == 0 || s.length() < k) return s.length();

        int slow = 0, fast = 0;

        int[] charMap = new int[256]; // all ascii chars

        int distinct = 0;

        int result = 0;

        while (fast < s.length()) {
            int ch = s.charAt(fast);
            if (charMap[ch] == 0) distinct++;
            charMap[ch] ++;

            if (distinct > k) {
                result = Math.max(result, fast - slow);
                while (distinct > k) {
                    int sch = s.charAt(slow++);
                    charMap[sch]--;
                    if (charMap[sch] == 0) distinct --;
                }
            }

            fast ++;
        }

        return Math.max(result, fast - slow);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0)
            return 0;
        // 可以换成 chat ->  in[]{freq, lastIndex}
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int max = 0;
        for(int l = 0, r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(r);
            if(map.size() <= k)
                max = Math.max(max, r - l + 1);
            else{
                char lc = s.charAt(l);
                List<Integer> indexs = map.get(lc);
                int lastIndex = indexs.get(indexs.size() - 1);
                l = lastIndex++;
                map.remove(lc);
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
