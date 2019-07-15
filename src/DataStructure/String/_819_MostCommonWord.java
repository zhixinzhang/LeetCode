package DataStructure.String;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class _819_MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.length() == 0)
            return "";
        String res = "";
        String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        LinkedHashMap<String, Integer>  linkedHashMap = new LinkedHashMap<>();

        for(String w : words){
//            w = w.toLowerCase().replaceAll("\\W+", "");
            //!?',;.
//            w = w.replaceAll("!","").replaceAll("/?", "").replaceAll("'","").
//                    replaceAll(",","").replaceAll("\\.","");

            linkedHashMap.putIfAbsent(w,0);
            int count = linkedHashMap.get(w) + 1;
            linkedHashMap.put(w, count);
        }

        int max = 0;
        HashSet<String> set = new HashSet<>();
        for (String s : banned)
            set.add(s.toLowerCase());
        for (Map.Entry<String, Integer> entry  :  linkedHashMap.entrySet()){
            int curN = entry.getValue();
            String curS = entry.getKey();

            if (!set.contains(curS) && curN > max){
                res = curS;
                max = curN;
            }

        }

        return res;
    }

    public static void main(String[] args){
        mostCommonWord("Bob!, hit. a ball?, the hit BALL flew far after it was hit.",new String[]{"hit"});
    }
}
