package Company.Google.Tree;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by zhang on 2018/7/31.
 * 第二题: Given a dictionary["technology", "nology", "google", "technique", "coo"] and an extra string "chnology", the only operation is to remove some characters from the string. Find the longest one existed in the given dictionary.
 In this example, return "nology". Word "coo" can also be formed by deleting some characters, but it is not the longest.
 Follow up: The only operation is to add some characters into the string. Find the longest one existed in the given dictionary. In the above example, return "technology".
 */
public class LongestStringInDictionary_Sort_twopointer {
    public static void main(String[] args){
        solu(new String[]{"technology", "nology", "google", "technique", "coo"},"chnology");
    }
    public static String solu(String[] dic, String s){
        HashSet<String> hs = new HashSet<>();
        for (String d : dic) hs.add(d);
        Arrays.sort(dic,(a,b)->(b.length() - a.length()));
        for (String d : dic){
            if (d.length() > s.length())
                continue;
            if (isSubSeq(d,s))
                return d;
        }
        return "";
    }
    public static boolean isSubSeq(String d, String s){
        //technology google  chnology
        for (int i = 0,j = 0;  i < d.length() && j<s.length(); i++){
            if (d.charAt(i) == s.charAt(i)){
                i++;
                j++;
            } else{
                j++;
            }
            if (i == d.length()-1)
                return true;
        }
        return false;
    }

}
