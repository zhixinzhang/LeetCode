package DataStructure.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/13/19
 * Time: 2:35 PM
 * Description:
 */


public class _1023_CamelcaseMatching_ {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        if(queries == null || queries.length == 0)
            return new ArrayList<>();
        List<Boolean> res = new ArrayList<>();
        for (String s : queries){
            res.add(isMatch(s, pattern));
        }
        return res;
    }
    public boolean isMatch(String query, String pattern){
        int i = 0;
        for (char c: query.toCharArray()) {
            if (i < pattern.length() && c == pattern.charAt(i))
                i++;
            else if (c < 'a')
                return false;
        }
        return i == pattern.length();
    }
}
