package DataStructure.Array;
import java.util.*;

// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/solutions/877222/java-simple-hash-arraylist/
public class _1604_AlertUsingSameKeyCardThreeMoreTimes_Map_SlidingWindow {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < keyName.length; i++) { // cache all visits for same person.
            String k = keyName[i];
            map.computeIfAbsent(k, g -> new ArrayList<>());
            map.get(k).add(getTime(keyTime[i]));
        }
        
        for (String k : map.keySet()) {
            List<Integer> l = map.get(k);
            Collections.sort(l);  // sort to find the connective checkins
            for (int i = 2; i < l.size(); i++)
                if (l.get(i) - l.get(i - 2) <= 60) {  // connective 3 within 60 mins.
                    res.add(k);
                    break;
                }
        }
        
        Collections.sort(res);
        return res;
    }
    
    private int getTime(String t) {  // transfer stirng to relative mins.
        String[] ss = t.split(":");
        return Integer.parseInt(ss[1]) + 60 * Integer.parseInt(ss[0]);
    }
}
