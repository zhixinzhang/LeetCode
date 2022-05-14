package DataStructure.Design;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/solution/
 * Key Point: 用一个HashMap 跟 一个list 数组
 * map key： 操作的数值 value ： 一个存index 的list
 * 另一个list 来存 所有单个数值 以及数值
 */

public class _381_InsertDeleteGetRandomDuplicatesallowed_Map {


    /** Initialize your data structure here. */
    private List<int[]> values;
    private Map<Integer, List<Integer>> map;
    private Random rand;
    public _381_InsertDeleteGetRandomDuplicatesallowed_Map() {
        values = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new ArrayList<>());
            return true;
        }
        map.get(val).add(values.size());
        values.add(new int[] {map.get(val).size() - 1, val});
        return false;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        List<Integer> elements = map.get(val);
        int index = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        if (elements.size() == 0) {
            map.remove(val);
        }
        int[] last = values.get(values.size() - 1);
        int lastValue = last[1];
        if (index != values.size() - 1) {
            values.set(index, last);
            List<Integer> replacedElements = map.get(lastValue);
            replacedElements.set(last[0], index);
        }
        values.remove(values.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int index = rand.nextInt(values.size());
        return values.get(index)[1];
    }
}
