package greedy;

import java.util.Arrays;
import java.util.Hashtable;

/**Given a string, find the length of the longest substring without repeating characters.
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Created by zhang on 2017/3/2.
 */
public class LongestSubstringWithou3 {
    //我自己的方法  timeLimited
//    public static int lengthOfLongestSubstring(String s) {
//        int start = 0;
//        int len = 0;
//        Hashtable<Character,DataStructure.Integer> hashtable = new Hashtable<Character,DataStructure.Integer>();
//        if (s.length() == 1) return 1;
//        for(int i = 0;i<s.length();) {
//            if (i+1<=s.length()){
//                if (i == s.length()-1){
//                    if (!hashtable.containsKey(s.charAt(i))) {
//                        hashtable.put(s.charAt(i), i);
//                        len = Math.max(len, hashtable.size());
//                        break;
//                    } else {
//                        len = Math.max(len, hashtable.size());
//                       break;
//                    }
//                }
//                if (s.charAt(i) != s.charAt(i + 1)) {
//                    if (!hashtable.containsKey(s.charAt(i))) {
//                        hashtable.put(s.charAt(i), i);
//                        i++;
//                    } else {
//                        len = Math.max(len, hashtable.size());
//                        int key = hashtable.get(s.charAt(i));
//                        start =  key +1;
//                        hashtable.clear();
//                        i = start;
//                    }
//                }else {
//                    if (!hashtable.containsKey(s.charAt(i))) {
//                        hashtable.put(s.charAt(i), i);
//                    }
//                    len = Math.max(len,hashtable.size());
//                    hashtable.clear();
//                    i++;
//                }
//            }
//        }
//        return len;
//    }


    public static int lengthOfLongestSubstring(String s) {
        final int ASCII_MAX = 255;
        int[] last = new int[ASCII_MAX]; // 记录字符上次出现过的位置
        int start = 0; // 记录当前子串的起始位置
        Arrays.fill(last, -1); // 0也是有效位置，因此初始化为-1
        int max_len = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            if (last[s.charAt(i)] >= start) {
                max_len = Math.max(i - start, max_len);
                start = last[s.charAt(i)] + 1;
            }
            last[s.charAt(i)] = i;
        }
        int result = Math.max((int)s.length() - start, max_len);
        return Math.max((int)s.length() - start, max_len); // 别忘了最后一次，
    }

    public  static  void main(String[] args){
        String s = "bpfbhmipx";
        lengthOfLongestSubstring(s);

    }
}
