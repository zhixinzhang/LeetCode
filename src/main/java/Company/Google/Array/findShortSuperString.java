package google.Array;
import java.util.HashSet;

/**
 * Created by zhang on 2018/6/16.
 * http://www.techiedelight.com/shortest-superstring-problem/
 */
public class findShortSuperString {
    public static String solution(String[] strings){
        String s1 = "AAAA"; String s2 = "ACAB";
        HashSet<String> suffix = new HashSet<>();
        for (int i = 0; i<s1.length(); i++){
            suffix.add(s1.substring(i,s1.length()));    // AAAA, AAA, AA, A
        }
        String res = s1 + s2;
        for (int i = 0; i<s2.length(); i++){
            if (suffix.contains(s2.substring(0,i))){
                String a = s1 + s2.substring(i,s2.length());
                res = a.length() < res.length() ? a : res;
            }
        }
        return res;
    }
    public static void main(String[] args){
        solution(new String[]{});
    }
}
