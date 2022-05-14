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
    class Node{
        String url;
        Node next;
        Node pre;
        public Node(String url){
            this.url = url;
        }
    }

    Node head = new Node("");
    Node tail = new Node("");
    Node current = head;

    public _1472_DesignBrowserHistory_DoubleLIstNode_Map(String homepage) {
        Node tmp = new Node(homepage);
        head.next = tmp;
        tmp.next = tail;
        tail.pre = tmp;
        tmp.pre = head;
        current = tmp;
    }

    public void visit(String url) {
        Node tmp = new Node(url);
        current.next = tmp;
        tmp.pre = current;

        tmp.next = tail;
        tail.pre = tmp;
        current = tmp;
    }

    public String back(int steps) {
        while(current.pre != head && steps > 0){
            current = current.pre;
            steps--;
        }
        return current.url;
    }

    public String forward(int steps) {
        while(current.next != tail && steps > 0){
            current = current.next;
            steps--;
        }
        return current.url;

    }


    // solution 2  Java, one List and a pointer, O(1) time:
    // https://leetcode.com/problems/design-browser-history/discuss/783294/Java-HashMap.
    Map<Integer, String> map;
    int cur, max;
    public void _1472_DesignBrowserHistory_Map(String homepage) {
        map = new HashMap<>();
        cur = 1;
        max = 1;
        map.put(cur, homepage);
    }

    public void visitMap(String url) {
        cur++;
        map.put(cur, url);
        max = cur;
    }

    public String backMap(int steps) {
        cur = Math.max(cur -steps,1);
        return map.get(cur);
    }

    public String forwardMap(int steps) {
        cur =Math.min(cur +steps,max);
        return map.get(cur);
    }
}
