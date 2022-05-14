package Company.Instacart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Luke Zhang
 * @Date 2021-08-15 14:15
 *
 * 设计key-value store:
 *
 * (1) 简单的get by key
 * (2) get的时候不给timestamp就返回最新的，给了timestamp的话就去查找有没有这个timestamp的value，没有的话返回null
 * (3) get的时候不给timestamp就返回最新的，给了timestamp的话就去查找有没有这个timestamp的value，
 * 没有的话返回这个timestamp之前的最新的valu‍‌‌‌‌‍‌‌‍‍‌‌‍‌‌‍‌‍‌e
 */
public class _981_TimeBasedKeyValueStore_3API_TreeMap {
    static Map<String, TreeMap<Integer, String>> map = new HashMap<>();
    public static void main(String[] args){
        map.put("test1", new TreeMap<>());
        map.get("test1").put(2, "a");
        map.get("test1").put(3, "b");
        map.get("test1").put(4, "c");

        get_Largest_Recen("test1", 1);
        get_Largest("test1", 4);
        get_Largest("test1");
        get("test1");
    }


    private static List<String> get(String key){
        if (map.containsKey(key)){
            TreeMap<Integer, String> treeMap = map.get(key);
            List<String> res = new ArrayList<>(treeMap.values());
            return res;
        }
        return new ArrayList<>();
    }

    private static String get_Largest(String key){
        if (map.containsKey(key)){
            TreeMap<Integer, String> treeMap = map.get(key);
            int res = treeMap.lastKey();
            return treeMap.get(res);

        }
        return "";
    }

    private static String get_Largest(String key, int timeStamp){
        if (map.containsKey(key)){
            TreeMap<Integer, String> treeMap = map.get(key);
            String ans = treeMap.getOrDefault(timeStamp, "");
            return ans;
        }
        return "";
    }

    private static String get_Largest_Recen(String key, int timeStamp){
        if (map.containsKey(key)){
            TreeMap<Integer, String> treeMap = map.get(key);
            if (treeMap.containsKey(timeStamp)){
                return treeMap.get(timeStamp);
            } else {

                Integer k = treeMap.floorKey(timeStamp);
                if (k == null) {
                    return "";
                }
                String va = treeMap.get(k);
                return va;
            }
        }
        return "";
    }
}
