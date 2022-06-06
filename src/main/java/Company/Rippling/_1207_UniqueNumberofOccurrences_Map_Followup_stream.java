package Company.Rippling;

import java.util.*;

// 用两个map 一个count 出现次数 一个遍历
// stream
public class _1207_UniqueNumberofOccurrences_Map_Followup_stream {
    public static boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr){
            int freq = map.getOrDefault(i, 0)  + 1;
            map.put(i, freq);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (set.contains(entry.getValue()))
                return false;
            set.add(entry.getValue());
        }

        return true;
    }


     /**Follow Up Stream*/
     public boolean uniqueOccurrences_stream(int[] arr) {
         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
         Arrays.stream(arr).forEach(a -> map.put(a, map.getOrDefault(a, 0) + 1));
         Set<Integer> set = new HashSet<Integer>();
         return map.values().stream().allMatch(set::add);
     }

    public static void main(String[] args){
        uniqueOccurrences(new int[]{1,2,2,1,1,3});
    }
}
