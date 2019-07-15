package DataStructure.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang on 2017/9/22.
 */
/**O(n) 时间里   不能用brute force  一次循环 两个指针 都从第一个字母开始
 *
 * */
public class _76_MinimumWindowSubstring_SlidingWindow {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s.length())
            return new String();
        int[] map = new int[128];
        int count = t.length(), start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for(char c: t.toCharArray()) {
            map[c]++;
        }
        char[] chS = s.toCharArray();
        while(end < chS.length){
            if(map[chS[end++]]-- > 0)
                count--;
            while(count == 0){
                if(end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if(map[chS[start++]]++ == 0)
                    count++;
            }

        }
        return minLen == Integer.MAX_VALUE ? new String() :new String(chS, startIndex, minLen);
    }

}
