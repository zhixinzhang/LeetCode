package DataStructure.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Luke Zhang
 * @Date 2021-06-12 17:56
 */
public class _1348_TweetCountsPerFrequency_TreeMap {
    private Map<String, TreeMap<Integer, Integer>> map;

    public _1348_TweetCountsPerFrequency_TreeMap() {
        map = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        if (!map.containsKey(tweetName)) map.put(tweetName, new TreeMap<>());
        TreeMap<Integer, Integer> tweetMap = map.get(tweetName);
        tweetMap.put(time, tweetMap.getOrDefault(time, 0) + 1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        if (!map.containsKey(tweetName)) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, Integer> tweetMap = map.get(tweetName);
        int interval = 0, size = 0;
        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 3600;
        } else {
            interval = 86400;
        }
        size = ((endTime - startTime) / interval) + 1;

        int[] buckets = new int[size];

        for (Map.Entry<Integer, Integer> entry : tweetMap.subMap(startTime, endTime + 1).entrySet()) {

            int index = (entry.getKey() - startTime) / interval;
            buckets[index] += entry.getValue();
        }

        for (int num : buckets) res.add(num);

        return res;
    }
}
