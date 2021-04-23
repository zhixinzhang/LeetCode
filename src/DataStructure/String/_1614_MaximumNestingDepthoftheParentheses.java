package DataStructure.String;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/23/2021 12:56 AM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _1614_MaximumNestingDepthoftheParentheses {
    public int maxDepth(String s) {
        int curParenth = 0, ans = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                curParenth++;
                ans = Math.max(ans, curParenth);
            } else if (s.charAt(i) == ')'){
                curParenth--;
            }
        }

        return ans;
    }

    // follow up  给定带括号的string， 求最深一层括号里的substring
    // https://www.1point3acres.com/bbs/thread-738888-1-1.html

    public String maxDepthSubString(String s) {
        int cur = 0, len = 0;
        String res = "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                cur++;
                if (cur >= len){
                    while (i < s.length()){
                        if (s.charAt(i) == '(') {
                            cur++;
                        } else if(s.charAt(i) == ')') {
                            len = Math.max(len, cur);
                            cur--;
                            res = sb.toString();
                            break;
                        } else {
                            sb.append(s.charAt(i));
                        }
                    }
                }
            } else if (s.charAt(i) == ')'){
                cur--;
            }
        }

        return res;
    }

}
