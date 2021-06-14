package Company.Twitter;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/13/2021 3:25 AM
 * <p>
 * Source Link:
 * <p> https://www.1point3acres.com/bbs/thread-664714-1-1.html
 * Description:
 * <p> 店面：
 * 刷题网 三霸凌 的延伸，就是除了原题的要求，还要求getLast也是O(1)。所以要用map+doubly linked list来找getlast，map+list来找getrandom。
 * 写完了还要写unit tests，refactor code，还问有更多时间还可以做什么，比如加更多的api啊，注释啊，之类的
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

class DoubleListNode{
    int val;
    DoubleListNode next;
    DoubleListNode prev;

    public DoubleListNode (int val) {
        this.val = val;
    }
}

public class _380_InsertDeleteGetRandom_GetLast_Map {

    static Map<Integer, Integer> map;
    static Map<Integer, DoubleListNode> doubleLMap;

    static DoubleListNode tailNode;
    static List<Integer> indexList;
    static Random random;
    
    public _380_InsertDeleteGetRandom_GetLast_Map() {
        map = new HashMap<>();
        doubleLMap = new HashMap<>();
        indexList = new ArrayList<>();
        random = new Random();

        tailNode = new DoubleListNode(-1);
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public static boolean insert(int val) {
        if (map.containsKey(val)) return false;

        map.put(val, indexList.size());
        indexList.add(indexList.size(), val);

        DoubleListNode doubleListNode = new DoubleListNode(val);

        tailNode.next = doubleListNode;
        doubleListNode.prev = tailNode;
        tailNode = tailNode.next;
        doubleLMap.put(val, doubleListNode);

        return true;
    }

    public static int getLastOne(){
        return tailNode.val;
    }

    public static boolean remove(int val){
        if (!map.containsKey(val)) return false;

        // move the last element to the place idx of the element to delete
        int lastElement = indexList.get(indexList.size() - 1);
        int idx = map.get(val);

        indexList.set(idx, lastElement);
        map.put(lastElement, idx);

        // delete the last element
        indexList.remove(indexList.size() - 1);
        map.remove(val);

        DoubleListNode curNode = doubleLMap.get(val);
        DoubleListNode pre = curNode.prev;
        DoubleListNode next = curNode.next;
        pre.next = curNode.next;
        if (next != null)
            next.prev = pre;

        // update tail
        if (tailNode.val == val) {
            tailNode = tailNode.prev;
        } else {
            DoubleListNode tempTailNode = doubleLMap.get(tailNode.val);
            tailNode = tempTailNode;
        }

        doubleLMap.remove(val);

        return true;
    }

    public static int getRandom(){
        int res = indexList.get(random.nextInt(indexList.size()));
        return res;
    }

    public static void main(String[] args){
        _380_InsertDeleteGetRandom_GetLast_Map m = new _380_InsertDeleteGetRandom_GetLast_Map();

        m.insert(1);
        m.insert(1);
        m.insert(1);
        m.insert(2);
        m.insert(3);
        m.insert(4);

        System.out.println(m.getRandom());
        System.out.println(m.getLastOne());

        System.out.println(m.remove(4));
        System.out.println(m.getLastOne());
        System.out.println(m.getRandom());

        System.out.println(m.remove(2));
        System.out.println(m.getLastOne());


        System.out.println(m.remove(1));
        System.out.println(m.getLastOne());

        System.out.println(m.remove(3));
        System.out.println(m.getLastOne());
    }
    
}
