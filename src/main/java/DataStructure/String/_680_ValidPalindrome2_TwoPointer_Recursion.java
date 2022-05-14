package DataStructure.String;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/3/2021 8:28 PM
 * <p>
 * Description:
 * Key Point:
 */

public class _680_ValidPalindrome2_TwoPointer_Recursion {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return true;
        }

        // two pointers
        int len = s.length();
        int l = 0, r = len - 1;

        while (l <= r){
            if (s.charAt(l) == s.charAt(r)) {
                l ++;
                r --;
            } else {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int l, int r){
        while (l <= r){
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l ++;
            r --;
        }

        return true;
    }

    // Recursion k

    public boolean validPalindrome_recursion(String s) {
        return valid(s, 0, s.length() - 1, 1);
    }

    public boolean valid(String s, int i, int j, int d){
        while(i<j){
            if (s.charAt(i) != s.charAt(j)) {
                if(d == 0) return false;
                return valid(s, i+1, j, d-1) ||  valid(s, i, j-1, d-1);
            }
            i++;
            j--;
        }
        return true;


    }
}
