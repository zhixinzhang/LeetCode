package company.Google2019;

import javafx.util.Pair;


/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description:
 * Key Point:
 * https://leetcode.com/problems/time-based-key-value-store/
 * https://leetcode.com/problems/time-based-key-value-store/solution/
 * hashmap + binary search
 *
 * Used new pair
 *
 * Note:
 *
 * All key/value strings are lowercase.
 * All key/value strings have length in the range [1, 100]
 * The timestamps for all TimeMap.set operations are strictly increasing.
 * 1 <= timestamp <= 10^7
 * TimeMap.set and TimeMap.get functions will be called a total of 120000 times (combined) per test case.
 */

import java.util.*;

class Data {
    String val;
    int time;

    Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}
public class _981_TimeBasedKeyValueStore_Design_Pair {

    // Solution 1: build a new Data class
    Map<String, List<Data>> map;

    public  _981_TimeBasedKeyValueStore_Design_Pair() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }

    protected String binarySearch(List<Data> list, int time) {
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (list.get(mid).time == time) return list.get(mid).val;
            if (list.get(mid).time < time) {
                if (list.get(mid+1).time > time) return list.get(mid).val;
                low = mid + 1;
            } else
                high = mid -1;
        }
        return list.get(low).time <= time ? list.get(low).val : "";
    }

    // Solution 2 : use new pair, the all pair already by timestamp based on description

    Map<String, List<Pair<Integer, String>>> cache = new HashMap<>();

    public void set_pair(String key, String value, int timestamp) {
        if (!cache.containsKey(key))
            cache.put(key, new ArrayList<Pair<Integer, String>>());

        cache.get(key).add(new Pair(timestamp, value));
    }

    public String get_pair(String key, int timestamp) {
        if (!cache.containsKey(key)) return "";

        List<Pair<Integer, String>> pairs = cache.get(key);
        int binary = Collections.binarySearch(pairs, new Pair<>(timestamp, "{"), (a, b) -> (a.getKey() - b.getKey()));
//        int i = Collections.binarySearch(A, new Pair<Integer, String>(timestamp, "{"),
//                (a, b) -> Integer.compare(a.getKey(), b.getKey()));

        if (binary >= 0)
            return pairs.get(binary).getValue();
        else if (binary == -1)
            return "";
        else
            return pairs.get(-binary-2).getValue();
    }
}
