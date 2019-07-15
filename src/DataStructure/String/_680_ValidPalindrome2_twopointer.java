package DataStructure.String;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/10/19
 * Time: 10:26 PM
 * Description:
 */


public class _680_ValidPalindrome2_twopointer {
    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
        return true;
    }

    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
}
