package Company.Google.Array;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/6/24.
 */
public class findSmallestLongest_HM_PQ {
    public static String[] solution(String[] strings, char[] cc){
        if (strings == null || strings.length == 0)
            return new String[]{};
        String[] res = new String[cc.length];
        HashMap<Character, PriorityQueue<String>> hm = new HashMap<>();
        for (String s : strings){
            hm.putIfAbsent(s.charAt(0),new PriorityQueue<>((a,b)->(a.length()- b.length())));
            hm.get(s.charAt(0)).add(s);
        }
        int i = 0;
        for (char c : cc){
            if (!hm.containsKey(c))
                res[i] = "";
            else
                res[i] = hm.get(c).peek();
            i++;
        }
        return  res;
    }

    public static void main(String[] args){
        solution(new String[]{"abaaa","abcd","aaa","ccc","cdwee"},new char[]{'a','b','c'});
    }
}
