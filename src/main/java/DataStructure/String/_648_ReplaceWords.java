package DataStructure.String;
import java.util.*;
/**
 * Created by zhang on 2018/1/4.
 */
public class _648_ReplaceWords {
    public static void main(String[] args){
        List<String> dict = new ArrayList<>();
        dict.add( "cat");
        dict.add( "bat");
        dict.add( "rat");
        replaceWords(dict,"the cattle was rattled by the battery");
    }
    public static String replaceWords(List<String> dict, String sentence) {
        String[] s = sentence.split(" ");
        String res = "";
        for(int i = 0; i<s.length;i++){
            res += findRoot(s[i],dict);
        }
        return res.trim();
    }
    private static String findRoot(String s, List<String> dict){
        for(int i = 0; i<dict.size();i++){
            String cur = dict.get(i);
            if(s.length() >= cur.length() && (s.substring(0,cur.length()).equals(cur))) {
                return cur+" ";
            }
        }
        return s + " ";
    }
}
