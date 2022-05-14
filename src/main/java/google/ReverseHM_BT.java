package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang on 2018/7/14.
 */
public class ReverseHM_BT {
    public static void main(String[] args){
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.putIfAbsent('a',1);
        hm.putIfAbsent('b',2);
        hm.putIfAbsent('c',3);
        hm.putIfAbsent('d',4);
        reverse(hm);
    }
    public static  String reverse(HashMap<Character, Integer> hm){
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Character> reHm = new HashMap<>();
        for (Map.Entry m : hm.entrySet()){
            reHm.putIfAbsent((int)m.getValue(),(char) m.getKey());
        }
        return sb.toString();
    }
}
