package Company.Apple;

import java.util.HashSet;

/**
 * Created by zhang on 2018/2/7.
 */
//“abcdabf”返回“abcdf”  O(n)
public class RemoveDupliString {
    public static String remove(String s){
        if (s == null || s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i<s.length();i++){
            Character c = s.charAt(i);
            if (!hs.contains(c)){
                sb.append(c);
                hs.add(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        remove("abcdabf");
    }
}
