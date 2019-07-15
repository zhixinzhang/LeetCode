package google.Array;
import java.util.*;
/**
 * Created by zhang on 2018/6/8.
 * https://blog.csdn.net/laserljy123/article/details/56390981
 * 就是有个字符串数组  找出相同的 字符串 他们之间每个字符的间距一样
 * 如果超过26 比如az ba 是一样的
 */
public class _249_GroupShiftedStrings_HM {
    public List<List<String>> groupStrings(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String word : strs){
            String key = "";
            int offset = word.charAt(0) - 'a';
            for(int i = 1; i < word.length(); i++){
                key += (word.charAt(i) - offset + 26) % 26;
            }

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
        }

        for(List<String> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }

        return res;
    }
}
