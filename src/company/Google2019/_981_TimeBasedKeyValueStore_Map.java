package company.Google2019;
//import javafx.util.Pair;

//https://leetcode.com/problems/time-based-key-value-store/
//https://leetcode.com/problems/time-based-key-value-store/solution/
// hashmap + binary search

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Data {
    String val;
    int time;
    Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}
public class _981_TimeBasedKeyValueStore_Map {
    Map<String, List<Data>> map;
    /** Initialize your data structure here. */
    public  _981_TimeBasedKeyValueStore_Map() {
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
}
