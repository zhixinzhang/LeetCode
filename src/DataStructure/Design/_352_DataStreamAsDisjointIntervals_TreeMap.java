package DataStructure.Design;

import java.util.TreeMap;

/**
 * @author Luke Zhang
 * @Date 2021-04-27 14:35
 */
public class _352_DataStreamAsDisjointIntervals_TreeMap {
    /** Initialize your data structure here. */
    TreeMap<Integer, int[]> map;
    public _352_DataStreamAsDisjointIntervals_TreeMap() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if(map.containsKey(val)) {
            return;
        }

        Integer higherKey = map.higherKey(val);
        Integer lowerKey = map.lowerKey(val);

        if (higherKey != null && lowerKey != null && val == map.get(lowerKey)[1] + 1
            && val == map.get(higherKey)[0] - 1) {
            map.get(lowerKey)[1] = map.get(higherKey)[1];
            map.remove(higherKey);
        } else if (lowerKey != null && val <= map.get(lowerKey)[1] +1 ){
            map.get(lowerKey)[1] = Math.max(val,map.get(lowerKey)[1]);
        } else if (higherKey != null && val == map.get(higherKey)[0] -1 ){
            map.put(val,new int[]{val,map.get(higherKey)[1]});
            map.remove(higherKey);
        } else {
            map.put(val,new int[]{val,val});
        }

    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (int[] interval : map.values()) {
            res[i] = interval;
            i++;
        }

        return res;
    }
}
