package DataStructure.String;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/25/2021 1:19 AM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _443_StringCompression_TwoPointer {
    public static void main(String[] args){
//        compress(new char[]{'a','a','b','b','c','c','c'});
        compress(new char[]{'a','a','b','b','c'});
    }

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        char prev = chars[0];
        sb.append(prev);

        for(int i = 1; i < chars.length; ){
            int len = 1;
            while (i < chars.length && prev == chars[i]){
                len++;
                i++;
            }

            if (len == 1) {
                sb.append(chars[i]);
            } else {
                sb.append(String.valueOf(len));
            }
            if (i >= chars.length) {
                break;
            }
            prev = chars[i];
            sb.append(prev);
            i++;
        }

        String ss = sb.toString();
        return ss.length();
    }

    public int compress_Solution(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}
