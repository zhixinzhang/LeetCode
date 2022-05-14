package DataStructure.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Luke Zhang
 * @Date 2021-04-26 18:34
 */
public class _981_TimeBasedKeyValueStore_BinarySearch {
    class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Data>> map;
    /** Initialize your data structure here. */
    public _981_TimeBasedKeyValueStore_BinarySearch() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";

        List<Data> lists = map.get(key);
        if (lists.get(0).timestamp > timestamp)
            return "";
        int left = 0, right = lists.size() - 1;
        while (left < right){
            int mid = left + (right - left) / 2 + 1;
            Data data = lists.get(mid);
            if (data.timestamp == timestamp) {
                return data.value;
            }

            if (data.timestamp < timestamp) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return lists.get(left).value;
    }
}
