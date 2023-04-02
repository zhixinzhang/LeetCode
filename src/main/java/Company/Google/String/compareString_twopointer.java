package Company.Google.String;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/27/19
 * Time: 10:44 PM
 * Description:
 */


public class compareString_twopointer {
    public static void main(String[] args){
        compare("abcd", "dbca");
    }
    public static boolean compare(String s1, String s2){
        if (s1.length() != s2.length()) return  false;
        if (s1 == null || s2 == null || s1 == s2)
            return false;
        int l = -1, r = -1;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) == s2.charAt(i)){
                continue;
            }else {
                if (r != -1)    return false;
                l = l == -1 ? i : l;
                if (l != -1 && l != i)
                    r = i;
            }
        }

        if (s1.charAt(l) == s2.charAt(r) && s1.charAt(r) == s2.charAt(l))
            return true;
        return false;
    }
}
