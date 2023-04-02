package Company.Google.Design;
import java.util.*;
/**
 * Created by zhang on 2018/6/20.
 */
public class _271_EncodeandDecodeStrings {
    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
//            String a = s.substring(2,2);
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }

    public static void main(String[] args){
        List<String> res = new ArrayList<>();
        res.add(null);
//        res.add("bbbb");
        String a =  encode(res);
        decode(a);
    }
}
