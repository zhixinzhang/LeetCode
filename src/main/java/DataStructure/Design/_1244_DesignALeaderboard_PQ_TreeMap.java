package DataStructure.Design;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/23/2021 11:37 PM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _1244_DesignALeaderboard_PQ_TreeMap {
    Map<Integer, Integer> map;
    public _1244_DesignALeaderboard_PQ_TreeMap() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        map.putIfAbsent(playerId, 0);
        map.put(playerId, map.get(playerId) + score);
    }

    public int top(int K) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > K)
                minHeap.poll();
        }

        int total = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = minHeap.iterator();
        while (iterator.hasNext()){
            int val = iterator.next().getValue();
            total += val;
            iterator.next();
        }

        return total;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }


    // TreeMap better solutions
    Map<Integer, Integer> record = new HashMap<>();
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public void addScoreTreeMap(int playerId, int score) {
        if (!map.containsKey(playerId)) {
            map.put(playerId, score);
            treeMap.put(score, treeMap.getOrDefault(score, 0) + 1);
        } else {
            int preScore = map.get(playerId);
            treeMap.put(preScore, treeMap.get(preScore) - 1);
            if (treeMap.get(preScore) == 0) {
                treeMap.remove(preScore);
            }
            int newScore = preScore + score;
            map.put(playerId, newScore);
            treeMap.put(newScore, treeMap.getOrDefault(newScore, 0) + 1);
        }
    }

    public int topTreeMap(int K) {
        int count = 0;
        int sum = 0;
        for (int key : treeMap.keySet()) {
            int times = treeMap.get(key);
            for (int i = 0; i < times; i++) {
                sum += key;
                count++;
                if (count == K) {
                    break;
                }
            }
            if (count == K) {
                break;
            }
        }
        return sum;
    }

    public void resetTreeMap(int playerId) {
        int preScore = map.get(playerId);
        treeMap.put(preScore, treeMap.get(preScore) - 1);
        if (treeMap.get(preScore) == 0) {
            treeMap.remove(preScore);
        }
        map.remove(playerId);
    }

}
