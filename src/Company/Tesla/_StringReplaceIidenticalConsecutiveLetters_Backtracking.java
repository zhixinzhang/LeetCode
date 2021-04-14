package Company.Tesla;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/12/2021 8:18 PM
 * <p>
 * Description:  https://www.1point3acres.com/bbs/thread-657538-1-1.html
 * 1. 给一个只有a跟b的string, 求return 最小的操作让a or b不会连续出现三次
 * ex 'aaa' -> 'aab'  ans: 1,   'bbaa' ans: 0
 * 李扣有讨论
 * Similar task :
 * Key Point:
 */

public class _StringReplaceIidenticalConsecutiveLetters_Backtracking {
    public static void main(String[] args){
//        findMinReplace("aaabbaaab");
        findMinReplace("aaa");
    }

    static int ans = Integer.MAX_VALUE;
    private static int findMinReplace(String s){
        if (s == null || s.length() <= 2) {
            return 0;
        }

        char[] chars = s.toCharArray();
        recursion(chars, 0, 0);
        return ans;
    }

    private static void recursion(char[] chars, int index, int count){
        if (index >= chars.length) {
            ans = Math.min(count, ans);
            return;
        }
        if (index >= 2) {
            if (chars[index] == chars[index - 1] && chars[index - 1] == chars[index - 2]) {
                return;
            }
        }
        chars[index] = chars[index] == 'a' ? 'b' : 'a';
        recursion(chars, index + 1, count + 1);
        chars[index] = chars[index] == 'a' ? 'b' : 'a';
        recursion(chars, index + 1, count);
    }
}
