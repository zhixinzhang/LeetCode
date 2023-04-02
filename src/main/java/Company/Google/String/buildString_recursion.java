package Company.Google.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/26/19
 * Time: 12:22 PM
 * Description:
 */


public class buildString_recursion {
    static List<String> ans = new ArrayList<>();
    public static void main(String[] args){
        recur("a{b,c}{d,e}fg", 0, "");
        int c = 0;
    }

    public static void recur(String s, int index, String cur){
        if (index >= s.length()-1){
            ans.add(cur);
            return;
        }
        String next = s.substring(index);
        int left = next.indexOf("{");
        int right = next.indexOf("}");
        if (left == -1 || right == -1){
            cur += next;
            ans.add(cur);
            return;
        }
        if (s.charAt(index) >= 'a' && s.charAt(index) <= 'b')
            cur += s.charAt(index);
        for (int i = left; i <= right; i++){
            if (next.charAt(i)>='a' && next.charAt(i)<='z'){
                String ss = cur + next.charAt(i);
                recur(s.substring(right+1),0, ss);
            }
        }
    }
}
