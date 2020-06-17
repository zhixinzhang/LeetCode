package XianQiao.CCI;

/**
 * @Author: Xianqiao
 * @Date: 6/11/20 14:20
 */

/** StringRotation:Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using
 * only one call to i5Sub5tring (e.g., "waterbottle" is a rotation of" erbottlewat"). */

public class CCI_9StringRotation {
    /** s1 = xy = waterbottle; x = wat; y = erbottle; s2 = yx = erbottlewat
     * yx is always a substring of xyxy, which is s2 is always a substring of s1s1 */

    boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return (isSubstring(s1s1, s2));
        }
        return false;
    }

    boolean isSubstring(String s1, String s2) {
        return true;
    }
}
