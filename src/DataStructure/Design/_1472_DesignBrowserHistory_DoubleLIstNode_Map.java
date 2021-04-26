package DataStructure.Design;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/26/2021 1:30 AM
 * <p>
 * Source Link:
 * https://leetcode.com/problems/design-browser-history/discuss/674388/Java-use-dual-LinkedList
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _1472_DesignBrowserHistory_DoubleLIstNode_Map {
    // solution 1 :
    class _1472Node{
        String url;
        _1472Node prev;
        _1472Node next;

        public _1472Node(String url) {
            this.url = url;
            this.prev = null;
            this.next = null;
        }
    }

    _1472Node head, tail;
    public _1472_DesignBrowserHistory_DoubleLIstNode_Map(String homepage) {
        head = new _1472Node(homepage);
        tail = head;
    }

    public void visit(String url) {
        head = new _1472Node(url);
        head.next = null;
        tail = head;
    }

    public String back(int steps) {
        while (tail.prev != null && steps != 0){
            steps--;
            tail = tail.prev;
        }

        return tail.url;
    }

    public String forward(int steps) {
        while (tail.next != null && steps != 0){
            steps --;
            tail = tail.next;
        }

        return tail.url;
    }


    // solution 2  Java, one List and a pointer, O(1) time:
    // https://leetcode.com/problems/design-browser-history/discuss/783294/Java-HashMap.
    Map<Integer, String> map;
    int current, max;
    public void _1472_DesignBrowserHistory_Map(String homepage) {
        map = new HashMap<>();
        current = 1;
        max = 1;
        map.put(current, homepage);
    }

    public void visitMap(String url) {
        current++;
        map.put(current, url);
        max = current;
    }

    public String backMap(int steps) {
        current = Math.max(current -steps,1);
        return map.get(current);
    }

    public String forwardMap(int steps) {
        current =Math.min(current +steps,max);
        return map.get(current);
    }
}
