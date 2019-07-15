package DataStructure.String;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/28/19
 * Time: 8:19 PM
 * Description:
 */


public class _451_SortCharactersByFrequency_Sort {
    public static void main(String[] args){
        frequencySort_Bucket("Aabb");
    }
    // o(n) time
    public static String frequencySort_Bucket(String s) {
        char[] arr = s.toCharArray();

        // bucket sort
        int[] count = new int[256];
        for(char c : arr) count[c]++;

        // count values and their corresponding letters
        Map<Integer, List<Character>> map = new HashMap<>();
        for(int i = 0; i < 256; i++){
            if(count[i] == 0) continue;
            int cnt = count[i];
            if(!map.containsKey(cnt)){
                map.put(cnt, new ArrayList<Character>());
            }
            map.get(cnt).add((char)i);
        }

        // loop throught possible count values
        StringBuilder sb = new StringBuilder();
        for(int cnt = arr.length; cnt > 0; cnt--){
            if(!map.containsKey(cnt)) continue;
            List<Character> list = map.get(cnt);
            for(Character c: list){
                for(int i = 0; i < cnt; i++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

        //O(nlogn)time
    public static String frequencySort(String s) {
        if(s == null || s.length() <= 2) return s;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        HashMap<Integer, List<Character>> hm = new HashMap<>();
        List<Integer> counts = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Character> ca_Char = new HashSet<>();

        for(char c : s.toCharArray()){
            if (ca_Char.add(c)){
                int count = freq.get(c);
                if(hs.add(count))
                    counts.add(count);
                List<Character> list = hm.getOrDefault(count, new ArrayList<Character>());
                list.add(c);
                hm.put(count, list);
            }
        }
        Collections.sort(counts,  (a,b)->(b-a));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < counts.size(); i++){
            List<Character> list = hm.get(counts.get(i));
            for(char c : list){
                for(int j = 0; j < counts.get(i); j++)
                    sb.append(c);

            }
        }
//        for(Map.Entry<DataStructure.Integer, List<Character>> entry : hm.entrySet()){
//        }

        return sb.toString();

    }
}
