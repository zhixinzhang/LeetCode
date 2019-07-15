package DataStructure.Integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/30/19
 * Time: 4:17 PM
 * Description:
 * https://leetcode.windliang.cc/leetCode-60-Permutation-Sequence.html
 *
 *
 */

// 我的解法是错误的
public class _60_PermutationSequence_BackTrack {
    public static void main(String[] args){
        getPermutation(3,9);
    }
    public static String getPermutation(int n, int k) {
        // 1 2 3 4 -> 1 2 4 3 , 1 3 2 4
        char[] c = new char[n];
        for(int i = 1; i <= n; i++){
            char a = String.valueOf(i).charAt(0);
            c[i-1] = a;
        }
        List<String> ans = new ArrayList<>();
        backtrack(ans, c, 0);
        Collections.sort(ans);
        return ans.get(k);
    }
    public static void backtrack(List<String> ans, char[] c, int index){
        for(int i = index+1; i < c.length; i++){
            swap(index, i, c);
            String s = String.valueOf(c);
            swap(index, i, c);
            ans.add(s);
        }
        if (index < c.length)
            backtrack(ans, c, ++index);
    }
    public static void swap(int l, int r, char[] chars){
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }
}
