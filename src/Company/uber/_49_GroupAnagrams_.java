package Company.uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhang on 2018/9/13.
 */
public class _49_GroupAnagrams_ {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            String curS = strs[i];
            int[] cc = new int[26];
            StringBuilder sb = new StringBuilder();
            // a e t -> 1 0 0  1  0 0 1
            for (int j = 0; j < curS.length(); j++){
                cc[curS.charAt(j) - 'a']++;
            }
            for(int c : cc){
                sb.append(c);
            }
            String s = sb.toString();
            hm.putIfAbsent(s, new ArrayList<>());
            hm.get(s).add(curS);
        }

        for(String key : hm.keySet()){
            res.add(hm.get(key));
        }

        return res;
    }
}
