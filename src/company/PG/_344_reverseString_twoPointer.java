package company.PG;

/**
 * Created by zhang on 2017/3/11.
 */
public class _344_reverseString_twoPointer {
    // space O(n) time O(n)
    public static  String reverseString(String s) {
        //return new StringBuilder(s).reverse().toString();
        String result = "";
        for (int i = s.length()-1;i>=0;i--){
            result = result + String.valueOf(s.charAt(i));
        }
        return  result;
    }
    /**
     * Reverse the specified string, in-place.
     * @param string
     * @return
     */
    public static char[] stringReverseInPlace(char[] string) {
        for(int i = 0, j = string.length - 1; i < string.length / 2; i++, j--) {
            char c = string[i];
            string[i] = string[j];
            string[j] = c;
        }
        return string;
    }

    public static void main(String args[]){
        String s = "abc cdd";
        reverseString(s);
    }
}
