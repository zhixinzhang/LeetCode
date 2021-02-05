package Company.Google2019;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 2/18/19
 * Time: 3:02 PM
 * Description:
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=482576&page=1&authorid=256744
 */


public class SnapShot_HashMap {
    static HashMap<String, String> hm = new HashMap<>();
    public static void main(String[] args){
        update("a","1");
        snap(new String[]{"a","b"});
    }
    private static void update(String A, String Value){
        hm.putIfAbsent(A,Value);
    }

    private static String snap(String[] strings){
        String res = "";
        for (String s : strings){
            res += hm.get(s);
        }
        return res;
    }
}
