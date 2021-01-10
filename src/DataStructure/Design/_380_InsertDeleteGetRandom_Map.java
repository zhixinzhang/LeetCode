package DataStructure.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/solution/
 * 重点是 用arraylist 可以 set（index， value）， map存 value 和 array的index
 * getRandom的时候 需要处理 list
 * O（1） time
 */
public class _380_InsertDeleteGetRandom_Map {

    HashMap<Integer, Integer> map;
    List<Integer> link;
    Random random;
    public _380_InsertDeleteGetRandom_Map(){
        map = new HashMap<>();
        link = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, link.size());
        link.add(link.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }

        int index = map.get(val);
        map.remove(val);
        link.set(index, link.get(link.size() -1));
        link.remove(link.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int ra = random.nextInt(link.size());
        return link.get(ra);
    }
}
