package XianQiao.CCI;

import java.util.HashSet;

/**
 * @Author: Xianqiao
 * @Date: 5/29/20 16:19
 */
public class CCI_isUnique {
    public boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }




    public boolean isUniqueChars_HashSet(String str) {
        HashSet<Character> cache = new HashSet<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!cache.add(chars[i])) {
                return false;
            }
        }
        return true;
    }
}


