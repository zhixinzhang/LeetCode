package DataStructure.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/17/19
 * Time: 12:04 PM
 * Description:
 * https://leetcode.com/problems/remove-comments/discuss/109197/One-pass-solution-in-Java
 *
 * 沒有什麼特殊算法，就是注意邊界條件
 */


public class _722_RemoveComments_ {
    public List<String> removeComments(String[] source) {
        if (source == null || source.length == 0) {
            return new ArrayList<String>();
        }
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isCommon = false;
        for (String s : source){
            for (int i = 0; i < s.length(); i ++){
                char c = s.charAt(i);
                if (isCommon) {
                    if (c == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        isCommon = false;
                        i++;        //skip '/' on next iteration of i
                    }
                } else {
                    if (c == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;      //ignore remaining characters on line s
                    } else if (c == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        isCommon = true;
                        i++;           //skip '*' on next iteration of i
                    } else {
                        sb.append(c);     //not a comment
                    }
                }
            }

            if (!isCommon && sb.length() > 0) {
                ans.add(sb.toString());
                sb = new StringBuilder();   //reset for next line of source code
            }
        }

        return ans;
    }
}
