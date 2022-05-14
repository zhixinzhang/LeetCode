package Company.zillow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhang on 2018/8/18.
 * Given an array of strings, group anagrams together.
 Example:
 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
//O（nk）
public class _49_GroupAnagrams_Map_String {
    public static List<List<String>> groupAnagrams(String[] strs) {
        //check corner case
        if(strs == null || strs.length == 0)    return null;
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String str : strs){
            int[] c = new int[26];
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<str.length(); i++){
                c[str.charAt(i) - 'a'] ++;
            }
            for(int cc : c)
                sb.append(cc);
            String s = sb.toString();
            hm.putIfAbsent(s,new ArrayList<>());
            hm.get(s).add(str);
        }
        for(String key : hm.keySet()){
            res.add(hm.get(key));
        }
        return res;
    }

    public static List<List<String>> groupAnagrams2_sort(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            hm.putIfAbsent(s,new ArrayList<>());
            hm.get(s).add(str);
        }
        for(String key : hm.keySet()){
            res.add(hm.get(key));
        }
        return res;
    }
        public static void main(String[] args){
        groupAnagrams2_sort(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
