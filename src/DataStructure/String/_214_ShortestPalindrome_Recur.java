package DataStructure.String;

/**
 * Created by zhang on 2017/11/29.
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation
 */
// 首先找到字符串里 从S[0] 开始的 最长回文字符串
public class _214_ShortestPalindrome_Recur {
    public static String shortestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return s;
        String res = "";
        int right = 0;
        for (int i = s.length() ; i>0;i--){
            String curStr = s.substring(0,i);
            if (isPali(curStr)){
                right = i;
                break;
            }
        }
        String a = s.substring(right,s.length());
        String c = new StringBuffer(a).reverse().toString();
        res = c + s;
        return res;
    }
    public static boolean isPali(String curStr){
        int right = curStr.length()-1;
        for (int i = 0; i < curStr.length();i++){
            if (curStr.charAt(i) != curStr.charAt(right)){
                return false;
            }else{
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String res = shortestPalindrome("aacecaaa");
    }
}
