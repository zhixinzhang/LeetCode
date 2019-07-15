package DataStructure.String;

/**
 * Created by zhang on 2017/9/18.
 *  Given "abcabcbb", the answer is "abc", which the length is 3.
 */

import java.util.Arrays;

/** key : two pointer  and  all numbers can be ASCII
 *
 *
 * */
public class _3_LongestSubstringWithout {
    public int lengthOfLongestSubstring(String s) {
        final int ASCII_MAX = 255;
        int[] last = new int[ASCII_MAX]; // 记录字符上次出现过的位置
        int start = 0; // 记录当前子串的起始位置
        Arrays.fill(last, -1); // 0也是有效位置，因此初始化为-1
        int max_len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (last[s.charAt(i)] >= start) {
                max_len = Math.max(i - start, max_len);
                start = last[s.charAt(i)] + 1;
            }
            last[s.charAt(i)] = i;
        }
        return Math.max((int)s.length() - start, max_len); // 别忘了最后一次，
    }
}
