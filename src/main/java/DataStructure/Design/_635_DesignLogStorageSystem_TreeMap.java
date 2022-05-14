package DataStructure.Design;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/10/19
 * Time: 8:54 PM
 * Description:
 */


public class _635_DesignLogStorageSystem_TreeMap {
    String min, max;
    private HashMap<String, Integer> map;
    private TreeMap<String, LinkedList<Integer>> logs;
    public _635_DesignLogStorageSystem_TreeMap() {
        min = "2000:01:01:00:00:00";
        max = "2017:12:31:23:59:59";
        map = new HashMap<>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
        logs = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        if (!logs.containsKey(id))
            logs.put(timestamp, new LinkedList<>());
        logs.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        int index = map.get(gra);
        String start = s.substring(0, index) + min.substring(index);
        String end = e.substring(0,index) + max.substring(index);
        NavigableMap<String, LinkedList<Integer>> subMap = logs.subMap(start, true, end, true);
        LinkedList<Integer> ans = new LinkedList<>();
        for (Map.Entry<String, LinkedList<Integer>>  entry : subMap.entrySet()){
            ans.addAll(entry.getValue());
        }
        return ans;
    }
}
