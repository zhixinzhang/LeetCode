package SystemDesign;

import java.util.HashMap;

/**
 * Created by zhang on 2018/3/28.
 *https://leetcode.com/problems/lru-cache/description/
 *
 * 1.The key to solve this problem is using a double linked list which enables us to quickly move nodes.
 2.The LRU cache is a hash table of keys and double linked nodes. The hash table makes the time of get() to be O(1).
 The list of double linked nodes make the nodes adding/removal operations O(1).
 */
public class _146_LRUCache_HashMap_Link {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer, Node> map;
    int capicity, count;
    Node head, tail;

    public void LRUCache(int capacity) {
        this.capicity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }
    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capicity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}
