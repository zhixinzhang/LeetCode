package Company.BloomBerg;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/24/2021 3:35 PM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 *
 * https://www.1point3acres.com/bbs/thread-725241-1-1.html
 * https://www.techiedelight.com/find-binary-strings-can-formed-given-wildcard-pattern/
 * The worst case time complexity is O(2^n)  and requires O(n) space, where n is the length of the input string.
 * THe worst case happens when all the string's character exponential number of strings gets generated
 */

public class _GenerateAllBinaryStringsFromGivenPattern_Recursion {
    public static void main(String[] args){
        finds("1??0?101");
    }

    static List<String> ans = new ArrayList<>();
    private static List<String> finds(String s){

        dfs(s, 0, new StringBuilder());
        return ans;
    }

    private static void dfs(String s, int index, StringBuilder sb){
        if (index >= s.length()) {
            ans.add(sb.toString());
            return;
        }

        if (s.charAt(index) != '?') {
            sb.append(s.charAt(index));
            dfs(s, index + 1, sb);
        } else {
            sb.append('0');
            dfs(s, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append('1');
            dfs(s, index + 1, sb);
        }

        sb.deleteCharAt(sb.length() - 1);
    }
}
